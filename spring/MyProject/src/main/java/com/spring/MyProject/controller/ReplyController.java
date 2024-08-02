package com.spring.MyProject.controller;

import com.spring.MyProject.dto.PageRequestDTO;
import com.spring.MyProject.dto.PageResponseDTO;
import com.spring.MyProject.dto.ReplyDTO;
import com.spring.MyProject.entity.Board;
import com.spring.MyProject.repository.BoardRepository;
import com.spring.MyProject.service.ReplyService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

// **
@RestController
@RequestMapping("/replies")
@Log4j2
public class ReplyController {

    private ReplyService replyService;
    private BoardRepository boardRepository;

    @Operation(summary = "Replies POST", description = "POST방식으로 전송")
    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long>  register(  // @Valid 제약조건 유효성 검사
            @Valid @RequestBody ReplyDTO replyDTO, // replyDTO랑 똑같은 이름의 클래스가 있으면 자동으로 값이 들어옴
            BindingResult bindingResult  // 유효성 검사 결과가 들어있음. 객체값 검증
            ) throws BindException {  //  에러가 존재하면 bindingResult에서 값을 받아서 리턴

        log.info("==> replyDTO: "+replyDTO);
        log.info("==> bindingResult: "+bindingResult.toString());
        log.info("==> ReplyDTO.get: "+replyDTO.getRno()+","+replyDTO.getBoard()+","+replyDTO.getReplyText()+","+replyDTO.getReplyer()+","+replyDTO.getRegDate()+","+replyDTO.getModDate());

        if (bindingResult.hasErrors()) {  // 에러가 존재하면 bindingResult에서 값을 받아서 BindException으로 리턴
            throw new BindException(bindingResult);
        }

        Long rno = replyService.register(replyDTO);


        Board board = Board.builder().bno(replyDTO.getBoard().getBno()).build();
        Map<String, Long> resultMap = Map.of("rno", 111L);
//        Map<String, String> resultMap = Map.of("bno", String.valueOf(replyDTO.getBno()), "replyText" , replyDTO.getReplyText(), "replyer", replyDTO.getReplyer());
//        resultMap.put("rno",300L);  // 에러 발생

//        return ResponseEntity.ok(resultMap);  // ResponseEntity.ok()  200성공 코드 + 반환값
//        return new ResponseEntity(resultMap, HttpStatus.OK);  // 같음
//        return ResponseEntity.ok(replyDTO);
        return resultMap;

    }

    @Operation(summary = "Replies of Board", description = "Post방식으로 특정 게시물의 댓글 목록")
    @PostMapping(value="/list/{bno}")
    public PageResponseDTO<ReplyDTO> getList (@PathVariable("bno") Long bno,
                                              PageRequestDTO pageRequestDTO) {

        PageResponseDTO<ReplyDTO> responseDTO = replyService.getListBoard(bno, pageRequestDTO);
        responseDTO.getDtoList().stream().forEach(reply-> log.info("==> reply: "+reply));

        return responseDTO;

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