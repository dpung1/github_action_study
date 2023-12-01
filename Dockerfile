# FROM -> 어떤 가상 환경에서 실행을 할 것인가 선택
# ARG -> Argument 대문자(스네이크) ex) TEST_NAME=test
# CMD -> 도커환경에서 명령어를 실행할 수 있음(1번만 가능)
# COPY -> TEST_NAME aaa (DB as같은 느낌)
# ENTRYPOINT -> ["java", "-Dspring.profiles.active=prod1", "-Dserver.env=green", "-jar", "파일명.jar"]

FROM amazoncorretto:11
ARG JAR_FILE=target/*.jar
ARG PROFILES
ARG ENV
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILES}", "-Dserver.env=${ENV}", "-jar", "app.jar"]