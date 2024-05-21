-- 사용자 계정 관리
-- 사용자 계정 등록
CREATE USER 'java01'@'localhost' IDENTIFIED BY '1234';
-- 원격 접속
-- CREATE USER 'java01'@'%' IDENTIFIED BY '1234';
-- 원격 접속 (특정 IP접속)
-- CREATE USER 'java01'@'192.168.*.*' IDENTIFIED BY '1234';
-- 등록된 계정에 권한 설정
GRANT ALL PRIVILEGES ON *.* TO 'java01'@'localhost';
-- 권한 회수
REVOKE ALL PRIVILEGES ON *.* FROM 'java01'@'localhost';
-- 계정 삭제
DROP USER 'java01'@'localhost';