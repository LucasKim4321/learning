package com.spring.MyProject.service;

import com.spring.MyProject.dto.PageRequestDTO;
import com.spring.MyProject.dto.PageResponseDTO;
import com.spring.MyProject.dto.ReplyDTO;
import com.spring.MyProject.entity.Board;
import com.spring.MyProject.entity.Reply;
import com.spring.MyProject.repository.BoardRepository;
import com.spring.MyProject.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;


    // 1. 댓글 등록
    @Override
    public Long register(ReplyDTO replyDTO) {

        /*
        // 게시글 번호 => board Entity 읽기 //  ReplyDTO에서 bno를 쓰기위한 임시방편
        Board board = boardRepository.findById(replyDTO.getBno()).orElseThrow();
        replyDTO.setBoard(board);

        // 1.1 dto -> entity
        Reply reply = modelMapper.map(replyDTO, Reply.class);
        Long rno = replyRepository.save(reply).getRno();
        */

        // dto -> entity
        Reply reply = dtoToEntity(replyDTO);
        // entity -> DB에 반영
        Long rno = replyRepository.save(reply).getRno();

        return rno;
    }

    // 2. 댓글 조회
    @Override
    public ReplyDTO read(Long rno) {
        Optional<Reply> replyOptional = replyRepository.findById(rno);
        Reply reply = replyOptional.orElseThrow();
        
//        return modelMapper.map(reply, ReplyDTO.class);
        return entityToDTO(reply);  // entity -> dto 전환 후 반환
    }

    // 3. 댓글 수정
    @Override
    public void modify(ReplyDTO replyDTO) {
        Optional<Reply> replyOptional = replyRepository.findById(replyDTO.getRno());
        Reply reply = replyOptional.orElseThrow();
        
        // 댓글 내용 수정
        reply. changeText(replyDTO.getReplyText());

        // DB 반영
        replyRepository.save(reply);

    }

    // 4. 댓글 삭제
    @Override
    public void remove(Long rno) {
        replyRepository.deleteById(rno);

    }

    // 5. 댓글 목록(페이징 기능이 있는 List)
    @Override
    public PageResponseDTO<ReplyDTO> getListBoard(Long bno, PageRequestDTO pageRequestDTO) {
        
        // PageREquest.of(0,10, 설정 옵션)
        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() <= 0 ? 0 : pageRequestDTO.getPage() -1,
                pageRequestDTO.getSize(),
                Sort.by("rno").ascending());

        // 조회된 결과를 Option타입으로 반환됨.
        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);

        // Optional객체 내에 있는 내용을 .getContent()의해 추출하여
        // entity- > dto전환하여 List구조에 저장
        List<ReplyDTO> dtoList =
                result.getContent()
                        .stream()
                        // .map(reply -> modelMapper.map(reply, ReplyDTO.class))  1:1 맵핑을 해줌
                        .map(reply -> entityToDTO(reply))
                        .collect(Collectors.toList());

        return PageResponseDTO.<ReplyDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }

}
