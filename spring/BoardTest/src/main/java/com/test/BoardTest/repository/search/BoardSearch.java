package com.test.BoardTest.repository.search;

import com.test.BoardTest.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {

    // 검색어가 포함된 페이징, Pageable인자는 마지막에 위치할 것
    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);

}
