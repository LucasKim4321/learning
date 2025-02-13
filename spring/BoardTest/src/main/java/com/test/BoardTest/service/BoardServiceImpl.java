package com.test.BoardTest.service;

import com.test.BoardTest.dto.BoardDTO;
import com.test.BoardTest.dto.PageRequestDTO;
import com.test.BoardTest.dto.PageResponseDTO;
import com.test.BoardTest.entity.Board;
import com.test.BoardTest.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service  // 서비스
@Log4j2
@RequiredArgsConstructor
@Transactional  // transaction단위로 작업
public class BoardServiceImpl implements BoardService{


    // @RequiredArgsConstructor + final 변수 == @Autowired된 변수랑 똑같음
    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    // 게시글 등록
    @Override
    public long register(BoardDTO boardDTO) {
        // 1. DTO -> Entity : 첨부파일이 없는 경우
        Board board = modelMapper.map(boardDTO, Board.class);  // boardDTO를 Board클래스에 1:1로 맵핑 시킴
        // 1:1 맵핑하는 작업을 수작업할 시 Board 변수에 일일이 넣어줘야함

        // 3. board entity 저장
        Long bno = boardRepository.save(board).getBno();  // 보드를 저장하고 정상적으로 작동하면 변수에 값 저장
        //Board savedBoard = boardRepository.save(board);

        return bno;
    }

    // 게시글 조회
    @Override
    public BoardDTO readOne(Long bno) {
        // 1. fetch = FetchType.LAZY 상태일 경우 boardImage 즉시 로딩 안됨
         Optional<Board> result = boardRepository.findById(bno);

        // optional -> entity
        Board board = result.orElseThrow();  // optional -> entity
//        log.info("==> board: "+board);

        // 1. entity -> dto 맵핑 (entity와 dto 동일 구조일 경우)
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);
        // 2. 다를 경우
//        BoardDTO boardDTO = entityToDTO(board);
//        log.info("==> boardDTO: "+boardDTO);

        return boardDTO;

    }

    // 게시글 수정
    @Override
    public Board modify(BoardDTO boardDTO) {

        // 수정할 글번호 유무 체크
        Optional<Board> result = boardRepository.findById(boardDTO.getBno());
        Board board = result.orElseThrow();
        log.info("==> from service board: "+board);

        board.change(boardDTO.getTitle(),boardDTO.getContent());

        // 저장하기
        Board modifiedBoard = boardRepository.save(board);

        return modifiedBoard;  // 수정된 board

    }

    // 게시글 삭제
    @Override
    public void remove(Long bno) {

        // 댓글 삭제 후 게시글 삭제
        boardRepository.deleteById(bno);

    }

    @Override
    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {

        // 검색 조건에 대한 처리
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("bno");

        // 조건 검색 및 페이징한 결과값 가져오기
        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);

        // page객체에 있는 내용을 List구조 가져오기
        List<BoardDTO> dtoList = result.getContent().stream()
                // collection 구조에 있는 entity를 하나씩 dto로 변환하여 List구조에 저장
                .map(board-> modelMapper.map(board,BoardDTO.class))
                .collect(Collectors.toList());

        // 매개변수로 전달받은 객체(pageRequestDTO)를 가지고 PageResponseDTO.Builder()를 통해
        // PageRequestDTO객체 생성되어 필요시 스프링이 필요시점에 주입 시켜줌(list에서 pageRequestDTO객체 사용가능함 )
        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();

    }
}
