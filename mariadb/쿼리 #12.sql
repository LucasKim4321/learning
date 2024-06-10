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



mysql이나 mariadb의 경우 호환이 잘 되지만
가끔은 데이터를 옮길때 한글깨짐이 발생할 수 있다.
그때는 다음과 같은 방법으로 해결할 수도 있다.
mysql -u -root -p --default-character-set=utf8 dbname < dbname.sql

특히 윈도우에 apm을 설치했을 경우엔
sql 파일을 mysql/bin 폴더에 넣고 실시해야함
그렇지 않다면 뒤에 경로를 입력해야 해 줌
mysql -u -root -p --default-character-set=utf8 dbname < /경로/dbname.sql

백업할 때도 주의.
mysqldump -u 아이디 -p --default-character-set=utf8 DB명 > 파일명.sql

SET NAMES 서로 다를 경우엔 예를들어
!40101 SET NAMES utf8mb4 ;
이 것의 문제일 경우 이 라인만 삭제하고 저장하면 됨
[출처] MySQL, MariaDB, sql파일 복구 한글깨짐 문제 해결|작성자 자연
*/