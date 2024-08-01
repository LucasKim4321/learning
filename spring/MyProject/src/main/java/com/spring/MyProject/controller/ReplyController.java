package com.spring.MyProject.controller;

import com.spring.MyProject.dto.ReplyDTO;
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
    
    @Operation(summary = "Replies POST", description = "POST방식으로 전송")
    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long>  register(  // @Valid 제약조건 유효성 검사
            @Valid @RequestBody ReplyDTO replyDTO, // replyDTO랑 똑같은 이름의 클래스가 있으면 자동으로 값이 들어옴
            BindingResult bindingResult  // 유효성 검사 결과가 들어있음. 객체값 검증
            ) throws BindException {  //  에러가 존재하면 bindingResult에서 값을 받아서 리턴

        log.info("==> replyDTO: "+replyDTO);
        log.info("==> bindingResult: "+bindingResult.toString());
        log.info("==> ReplyDTO.get: "+replyDTO.getRno()+","+replyDTO.getBno()+","+replyDTO.getReplyText()+","+replyDTO.getReplyer()+","+replyDTO.getRegDate()+","+replyDTO.getModDate());

        if (bindingResult.hasErrors()) {  // 에러가 존재하면 bindingResult에서 값을 받아서 BindException으로 리턴
            throw new BindException(bindingResult);
        }

        Map<String, Long> resultMap = Map.of("rno", 111L);
//        Map<String, String> resultMap = Map.of("bno", String.valueOf(replyDTO.getBno()), "replyText" , replyDTO.getReplyText(), "replyer", replyDTO.getReplyer());
//        resultMap.put("rno",300L);  // 에러 발생

//        return ResponseEntity.ok(resultMap);  // ResponseEntity.ok()  200성공 코드 + 반환값
//        return new ResponseEntity(resultMap, HttpStatus.OK);  // 같음
//        return ResponseEntity.ok(replyDTO);
        return resultMap;
    }
}
