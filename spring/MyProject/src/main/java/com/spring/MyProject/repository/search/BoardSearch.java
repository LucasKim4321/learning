package com.spring.MyProject.repository.search;


import com.spring.MyProject.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// 단순 페이지 처리 기능 설게
public interface BoardSearch {

    Page<Board> search(Pageable pageable);

}
