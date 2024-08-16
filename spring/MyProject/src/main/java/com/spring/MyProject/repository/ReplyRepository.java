package com.spring.MyProject.repository;

import com.spring.MyProject.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Reply에 대한 JpaRepository
public interface ReplyRepository extends JpaRepository<Reply, Long> {  // JpaRepository<엔티티명, 엔티티의 기본키명>

    // 1. 해당 게시글에 대한 댓글 조회
    @Query ("select r from Reply r where r.board.bno = :bno")
    Page<Reply> listOfBoard(Long bno, Pageable pageable);

    @Query ("select r from Reply r where r.board.bno = :bno")
    List<Long> listOfBoard2(Long bno);


    // 2. 해당 게시글에 대한 댓글 삭제:
    //   댓글이 참조하는 게시글 번호(부모 객체) 삭제
    void deleteByBoard_Bno(Long bno);

}
