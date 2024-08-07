USE shopdb;

SHOW COLUMNS FROM item;
SELECT * FROM item;
DELETE FROM item;
DROP TABLE item;

SHOW COLUMNS FROM board;
SELECT * FROM board;
DELETE FROM board;
DROP TABLE board;

SHOW COLUMNS FROM reply;
SELECT * FROM reply;
DELETE FROM reply;
DROP TABLE reply;

SHOW COLUMNS FROM member;
SELECT * FROM member;
DELETE FROM member;
DROP TABLE member;

SHOW COLUMNS FROM member_role_set;
SELECT * FROM member_role_set;
DELETE FROM member_role_set;
DROP TABLE member_role_set;

-- 검색한 결과 반환
SELECT * from board
WHERE writer LIKE '%user1%'
AND content LIKE '%content5%';

-- 검색한 결과를 카운트해서 반환
SELECT COUNT(*) from item
WHERE item_id LIKE '%상품4%'
or item_detail LIKE '%설명8%';

 select
        b1_0.bno,
        b1_0.title,
        b1_0.writer,
        b1_0.regdate,
        count(r1_0.rno) 
    from
        board b1_0 
    left join
        reply r1_0 
            on r1_0.board_bno=b1_0.bno 
    where
        (
            b1_0.title LIKE 1 escape '!' 
            or b1_0.content LIKE 1 ESCAPE '!' 
            or b1_0.writer LIKE 1 escape '!'
        ) 
        and b1_0.bno>0 
    group by
        b1_0.bno 
    order by
        b1_0.bno desc 
    limit
        0, 5
   ;
   
   select
        count(distinct b1_0.bno)
    from
        board b1_0 
    left join
        reply r1_0 
            on r1_0.board_bno=b1_0.bno 
    where
        (
            b1_0.title LIKE 1 escape '!' 
            or b1_0.content LIKE 1 escape '!' 
            or b1_0.writer LIKE 1 escape '!'
        ) 
        and b1_0.bno>0;