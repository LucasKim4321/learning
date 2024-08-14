package com.spring.MyProject.repository;

import com.spring.MyProject.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Reply에 대한 JpaRepository
public interface ReplyRepository extends JpaRepository<Reply, Long> {  // JpaRepository<엔티티명, 엔티티의 기본키명>

    @Query ("select r from Reply r where r.board.bno = :bno")
    Page<Reply> listOfBoard(Long bno, Pageable pageable);

    @Query ("select r from Reply r where r.board.bno = :bno")
    List<Long> listOfBoard2(Long bno);

}
