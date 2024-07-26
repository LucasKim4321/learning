package com.spring.MyProject.repository.search;

import com.querydsl.jpa.JPQLQuery;
import com.spring.MyProject.entity.Board;
import com.spring.MyProject.entity.QBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

// 구현 클래스 : 반드시 '인터페이스이름+impl" 표현해야 한다.
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch{

    // 인자가 있을 경우
    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search(Pageable pageable) {

        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);  // select ... from board
                         query.where(board.title.contains("1"));  // where title like ...
        return null;  // new PageImpl();
    }
}
