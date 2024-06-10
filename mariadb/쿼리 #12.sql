-- 백업 및 복원
-- root 사용자에게 적용되는 권한
-- MYSQLDUMP -u계정 -p비밀번호 백업선택 > 백업 파일의 위치 이름

-- mariadb위치
-- C:\Program Files\MariaDB 11.3\data\mydb

-- cmd에 입력
/*
 모든 DB백업
mysqldump -uroot -p3690 -A > C:/test/maria_backup.sql

특정 파일
mysqldump -uroot -p3690 mydb > C:\test\maria_backup2.sql

두 개 이상 백업
mysqldump -uroot -p3690 --databases mydb mysql > C:\test\maria_backup2.sql

특정 db의 특정 테이블 백업
mysqldump -uroot -p3690 mydb students > C:\test\maria_backup.sql

데이터 없이 db구조만 백업
mysqldump -uroot -p3690 --no-data -A > C:\test\maria_backup.sql

특정 db의 구조 백업
uroot -p3690 --no-data mydb > C:\test\mydb_schema_only.sql

자동 백업



*/