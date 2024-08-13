package com.spring.MyProject.controller;

import com.spring.MyProject.dto.BoardDTO;
import com.spring.MyProject.dto.BoardListReplyCountDTO;
import com.spring.MyProject.dto.PageRequestDTO;
import com.spring.MyProject.dto.PageResponseDTO;
import com.spring.MyProject.entity.Board;
import com.spring.MyProject.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;

    @GetMapping("")
    public String root2() {
        return "index";
    }

    @GetMapping("/root")
    public String root() {
        return "index";
    }


    // 1. 게시글 목록
    @GetMapping("/list")
    public String list(PageRequestDTO pageRequestDTO,
                       Model model){
        // PageRequestDTO 객체 생성만 했을 경우 기본값 설정

        // 1. 게시글 댓글 개수 없는 List 조회
//        PageResponseDTO responseDTO = boardService.list(pageRequestDTO);

        /// 1-2. 게시글 댓글 개수 있는 List 조회
        PageResponseDTO<BoardListReplyCountDTO> responseDTO = boardService.listWithReplyCount(pageRequestDTO);
        log.info("=> "+responseDTO);

        model.addAttribute("responseDTO", responseDTO);
        return "board/list";
    }

    // 2. 게시글 등록
    // 로그인 상태에서만 가능
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/register")
    public String registerGet() {

        // 게시글 등록 입력 폼 요청
        return "board/register";

    }
    // 로그인 상태에서만 가능
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/register")
    public String registerPost(@Valid BoardDTO boardDTO,  // @Valid 넘어온 데이터 BoardDTO의 에러 유무 체크
                               BindingResult bindingResult,  // 감지한 에러 데이터
                               RedirectAttributes redirectAttributes) {

        log.info("==> boardDTO: "+boardDTO);

        // 클라이언트로 부터 전송받은 boardDTO를 @valid에서 문제가 발생했을 경우
        if(bindingResult.hasErrors()) {
            log.info("==> has errors...");

            // 1회용 정보유지 : redirect방식으로 요청시 정보관리하는 객체
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());  // 한번 에러값을 보낸 후 없어짐

            // Get방식으로 board/register를 재요청
            return "redirect:/board/register";
        }
        
        log.info("==> "+boardDTO);
        // 게시글 등록 서비스 호출(DB에 저장)
        Long bno = boardService.register(boardDTO);

        redirectAttributes.addFlashAttribute("bno",bno);
        redirectAttributes.addFlashAttribute("result", "registered");


        return "redirect:/board/list";


    }

    // 3. 게시글 조회 및 수정 화면 => /board/read or /baord/modify 요청 처리

//    @PreAuthorize("isAuthenticated()")
//    @GetMapping({"/read", "/modify"})  // 두개이상 사용시 {}안에 ,쓰고 하나 더 입력
//    public void readAndModify(Long bno,
//                              PageRequestDTO pageRequestDTO,
//                              Model model) {
//        // 게시글 조회 서비스 요청
//        BoardDTO boardDTO = boardService.readOne(bno);
//        model.addAttribute("dto",boardDTO);
//        /*
//        반환값을 void로 할 경우
//        return 생략하면 "board/read" 형태으로 자동 포워딩  (return "board/read";)
//        또는
//        return 생략하면 "board/modify" 형태으로 자동 포워딩  (return "board/modify";)
//        */
//    }

    @GetMapping({"/read"})
    public void read(Long bno,
                              PageRequestDTO pageRequestDTO,
                              Model model) {
        // 게시글 조회 서비스 요청
        BoardDTO boardDTO = boardService.readOne(bno);
        model.addAttribute("dto",boardDTO);
        /*
        반환값을 void로 할 경우
        return 생략하면 "board/read" 형태으로 자동 포워딩  (return "board/read";)
        */
    }

    // 현재 로그인 사용자 이메일과 게시글 작성자 이메일이 동일하면 게시글 수정
//    @PreAuthorize("isAuthenticated() and principal.email == #boardDTO.email")
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify")  // 두개이상 사용시 {}안에 ,쓰고 하나 더 입력
    public void modifyget(Long bno,
                              PageRequestDTO pageRequestDTO,
                              Model model) {

        // 게시글 조회 서비스 요청
        BoardDTO boardDTO = boardService.readOne(bno);
        model.addAttribute("dto",boardDTO);

        /*
        반환값을 void로 할 경우
        return 생략하면 "board/modify" 형태으로 자동 포워딩  (return "board/modify";)
        */
    }

    // 4. 게시글 수정
    // 현재 로그인 사용자 이메일과 게시글 작성자 이메일이 동일하면 게시글 수정
//    @PreAuthorize("isAuthenticated() and principal.email == #boardDTO.email")
    //@PreAuthorize("isAuthenticated()")
    @PostMapping("/modify")
    public String modifypost(@Valid BoardDTO boardDTO,  // @Valid 넘어온 데이터 BoardDTO의 에러 유무 체크
                               BindingResult bindingResult,  // 감지한 에러 데이터
                               PageRequestDTO pageRequestDTO,
                               RedirectAttributes redirectAttributes) {

        log.info("==> boardDTO: "+boardDTO);  // 갑자기 값이 비어있음

        // 수정 페이지에서 넘겨받은 페이징 정보
        String link = pageRequestDTO.getLink();

        // 클라이언트로 부터 전송받은 boardDTO를 @valid에서 문제가 발생했을 경우
        if(bindingResult.hasErrors()) {
            log.info("==> has errors...");

            // addFlashAttribute() => 1회용 정보유지 : redirect방식으로 요청시 정보관리하는 객체
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());  // 한번 에러값을 보낸 후 없어짐
            redirectAttributes.addFlashAttribute("bno", boardDTO.getBno());

            // Get방식으로 board/modify+페이징정보 재요청
            return "redirect:/board/modify?"+link;
        }

        // 수정 서비스 요청
        Board board = boardService.modify(boardDTO);
        log.info("==> bno123: "+board.getBno());

        redirectAttributes.addFlashAttribute("bno", board.getBno());
        redirectAttributes.addFlashAttribute("result", "modified");

        // => return
        redirectAttributes.addAttribute("bno", board.getBno());

        return "redirect:/board/read?"+link;

    }

    @GetMapping("/modify2")
    public @ResponseBody String modifypost2(BoardDTO boardDTO) {
        return boardDTO.toString();
    }

    // 5. 게시글 삭제
    // 현재 로그인 사용자 이메일과 게시글 작성자 이메일이 동일하면 게시글 삭제
//    @PreAuthorize("isAuthenticated() and principal.email == #boardDTO.email")
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/remove")
    public String remove(BoardDTO boardDTO,
                         RedirectAttributes redirectAttributes){

        log.info("==> boardDTO: "+boardDTO);  // 갑자기 값이 비어있음

        Long bno = boardDTO.getBno();
        log.info("remove bno: "+bno);

        // 게시글 삭제 서비스 요청
        boardService.remove(bno);

        // addFlashAttribute() => 1회용 정보유지 : redirect방식으로 요청시 정보관리하는 객체
        redirectAttributes.addFlashAttribute("bno",bno);
        redirectAttributes.addFlashAttribute("result", "removed");

        return "redirect:/board/list";
    }



}
