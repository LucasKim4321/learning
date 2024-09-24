#참조 https://12bme.tistory.com/588

# open jdk 17버전 환경
FROM openjdk:17-alpine

#build시 JAR_FILE변수에 build/libs/*.jar => build/libs-gradle로 빌드했을 때 *.jar 파일 생성
ARG JAR_FILE=build/libs/*.jar

# agroup.jar 파일로 복사하기
COPY ${JAR_FILE} agaroup.jar

# 운영 및 개발에 사용되는 환경 설정
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/agaroup.jar"]

# 터미널 입력 docker build -t simplespringboot-app1 .
# 터미널 입력 docker run --name spring_boot_api_test -d -p 8082:8080 simplespringboot-app1