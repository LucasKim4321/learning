package com.spring.MyProject.controller;

import com.spring.MyProject.dto.PageRequestDTO;
import com.spring.MyProject.dto.PageResponseDTO;
import com.spring.MyProject.dto.ReplyDTO;
import com.spring.MyProject.repository.BoardRepository;
import com.spring.MyProject.service.ReplyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


// REST방식 : 주로 XML, JSON형태의 문자열을 전송하고 이를 컨트롤러에서 처리하는 방식
@Tag(name = "예제 API", description = "Swagger 테스트용 API")
@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;  // 댓글 서비스 객체

    // 댓글 등록
    @Operation(summary = "Replies POST", description = "POST방식으로 게시글 댓글 등록")
    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String>  register(  // @Valid 제약조건 유효성 검사
                                         @Valid @RequestBody ReplyDTO replyDTO, // replyDTO랑 똑같은 이름의 클래스가 있으면 자동으로 값이 들어옴
                                         BindingResult bindingResult  // 유효성 검사 결과가 들어있음. 객체값 검증
                                         ) throws BindException {  //  에러가 존재하면 bindingResult에서 값을 받아서 리턴

        log.info("==> replyDTO: "+replyDTO);
        log.info("==> bindingResult: "+bindingResult.toString());
        log.info("==> ReplyDTO.get: "+replyDTO.getRno()+","+replyDTO.getBno()+","+replyDTO.getReplyText()+","+replyDTO.getReplyer()+","+replyDTO.getRegDate()+","+replyDTO.getModDate());

        if (bindingResult.hasErrors()) {  // 에러가 존재하면 bindingResult에서 값을 받아서 BindException으로 리턴
            throw new BindException(bindingResult);
        }

        Long rno = replyService.register(replyDTO);


        //Board board = Board.builder().bno(replyDTO.getBno()).build();

        // 1
//        Map<String, String> resultMap = Map.of("bno", String.valueOf(replyDTO.getBno()), "replyText" , replyDTO.getReplyText(), "replyer", replyDTO.getReplyer());
//        resultMap.put("rno",300L);  // 에러 발생
//        return ResponseEntity.ok(resultMap);  // ResponseEntity.ok()  200성공 코드 + 반환값
//        return new ResponseEntity(resultMap, HttpStatus.OK);  // 같음
//        return ResponseEntity.ok(replyDTO);

        // 2
//        Map<String, Long> resultMap = Map.of("rno", rno);
//        return resultMap;

        // 3
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("rno", rno+"번 댓글이 등록되었습니다옹~");
        return resultMap;

    }

    // 2. 특정 게시물의 댓글 목록
    @Operation(summary = "Replies of Board", description = "Get방식으로 특정 게시물의 댓글 목록 조회")
    @GetMapping(value="/list/{bno}")
    public PageResponseDTO<ReplyDTO> getList (@PathVariable("bno") Long bno, // 경로에서 bno값을 받음
                                              PageRequestDTO pageRequestDTO) {

        log.info("==> pageRequestDTO: "+pageRequestDTO);
        log.info("==> bno: "+bno);

        PageResponseDTO<ReplyDTO> responseDTO = replyService.getListBoard(bno, pageRequestDTO);
        // 서버쪽에 클라이언트에 보내는 데이터: 페이징 객체, 댓글 리스트 ...
        return responseDTO;

//        responseDTO.getDtoList().stream().forEach(reply-> log.info("==> reply: "+reply));
//        Map<String, List<ReplyDTO>> resultMap = Map.of("list", responseDTO.getDtoList());
//        return resultMap;

    }

    // 댓글 수정
    @Operation(summary = "Replies Modified", description = "Put방식으로 댓글 수정")
    @PutMapping(value="/{rno}", consumes = MediaType.APPLICATION_JSON_VALUE) // 전송받은 data 종류
    public Map<String, Long> modify (@PathVariable("rno") Long rno, // 경로에서 rno값을 받음
                                     @RequestBody ReplyDTO replyDTO) {

        replyDTO.setRno(rno);  // 매개변수로 넘어온 댓글 번호를 replyDTO에 설정
        replyService.modify(replyDTO);

        // 클라이언트에게 보낼 data 정보 및 메시지
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("rno", rno);

        return resultMap;

    }


    // 댓글 삭제
    @Operation(summary = "Replies Modified", description = "Delete방식으로 댓글 삭제")
    @DeleteMapping(value="/{rno}", consumes = MediaType.APPLICATION_JSON_VALUE) // 전송받은 data 종류 명시
    public Map<String, Long> remove (@PathVariable("rno") Long rno) {  // 경로에서 rno값을 받음

        replyService.remove(rno);

        // 클라이언트에게 보낼 data 정보 및 메시지
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("rno", rno);

        return resultMap;

    }

    // 5. 댓글 조회
    @Operation(summary = "Read Reply", description = "Get방식으로 특정 댓글 조회")
    @GetMapping(value="/{rno}") // 전송받은 data 종류 명시
    public ReplyDTO getReplyDTO(@PathVariable("rno") Long rno) {

        ReplyDTO replyDTO = replyService.read(rno);

        return replyDTO;
    }

}


/*
Springdoc 공식 가이드에서 설명하는 어노테이션의 변화는 다음과 같다.

@Api → @Tag
@ApiIgnore
  → @Parameter(hidden = true) or @Operation(hidden = true) or @Hidden
@ApiImplicitParam
  → @Parameter
@ApiImplicitParams
  → @Parameters
@ApiModel
  → @Schema
@ApiModelProperty(hidden = true)
  → @Schema(accessMode = READ_ONLY)
@ApiModelProperty
  → @Schema
@ApiOperation(value = "foo", notes = "bar")
  → @Operation(summary = "foo", description = "bar")
@ApiParam
  → @Parameter
@ApiResponse(code = 404, message = "foo")
  → @ApiResponse(responseCode = "404", description = "foo")

 */