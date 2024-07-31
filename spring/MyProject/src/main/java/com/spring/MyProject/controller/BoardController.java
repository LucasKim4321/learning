package com.spring.MyProject.controller;

import com.spring.MyProject.dto.BoardDTO;
import com.spring.MyProject.dto.PageRequestDTO;
import com.spring.MyProject.dto.PageResponseDTO;
import com.spring.MyProject.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;
//    <link href="css/bootstrap.min.css" th:href="@{css/bootstrap.min.css}" 여기선 잘됨
    @GetMapping("")
    public String root2() {
        return "index";
    }

//    <link href="css/bootstrap.min.css" th:href="@{css/bootstrap.min.css}" 여기선 안됨
//    <link href="/css/bootstrap.min.css" th:href="@{/css/bootstrap.min.css}" 절대경로로 바꿔줘야함
    @GetMapping("/root")
    public String root() {
        return "index";
    }


    // 1. 게시글 목록
    @GetMapping("/list")
    public String list(PageRequestDTO pageRequestDTO, Model model){
        // PageRequestDTO 객체 생성만 했을 경우 기본값 설정

        PageResponseDTO responseDTO = boardService.list(pageRequestDTO);
        log.info("=> "+responseDTO);

        model.addAttribute("responseDTO", responseDTO);
        return "board/list";
    }

    // 2. 게시글 등록
    @GetMapping("/register")
    public String registerGet() {
        // 게시글 등록 입력 폼 요청
        return "board/register";

    }
    @PostMapping("/register")
    public String registerPost(@Valid BoardDTO boardDTO,  // @Valid 넘어온 데이터 BoardDTO의 에러 유무 체크
                               BindingResult bindingResult,  // 감지한 에러 데이터
                               RedirectAttributes redirectAttributes) {

        // 클라이언트로 부터 전송받은 boardDTO를 @valid에서 문제가 발생했을 경우
        if(bindingResult.hasErrors()) {
            log.info("==> has errors...");

            // 1회용 정보유지 : redirect방식으로 요청시 정보관리하는 객체
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());  // 한번 에러값을 보낸 후 없어짐

            return "redirect:/board/register";  // Get방식으로 board/register를 재요청
        }
        
        log.info("==> "+boardDTO);
        // 게시글 등록 서비스 호출(DB에 저장)
        Long bno = boardService.register(boardDTO);
        
        redirectAttributes.addFlashAttribute("result",bno);
        

        return "redirect:/board/list";


    }

    // 3. 게시글 조회
    @GetMapping("/read")
    public void read(Long bno, PageRequestDTO pageRequestDTO, Model model) {
        
        // 게시글 조회 서비스 요청
        BoardDTO boardDTO = boardService.readOne(bno);
        model.addAttribute("dto",boardDTO);

        // 반환값을 void로 할 경우
        // return 생략하면 "board/read" 형식을 포워딩  (return "board/read";)

    }


    // 4. 게시글 수정
    // 5. 게시글 삭제

}
