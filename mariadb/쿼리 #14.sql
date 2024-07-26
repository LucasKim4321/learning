USE shopdb;

SELECT * FROM item;
DELETE FROM item;
DROP TABLE item;

SELECT * FROM board;
DELETE FROM board;
DROP TABLE board;

-- 검색한 결과 반환
SELECT * from board
WHERE writer LIKE '%user1%'
AND content LIKE '%content5%';

-- 검색한 결과를 카운트해서 반환
SELECT COUNT(*) from item
WHERE item_id LIKE '%상품4%'
or item_detail LIKE '%설명8%';
