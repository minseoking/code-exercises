# stage 1
FROM openjdk:17.0.1-jdk-slim as build
LABEL maintainer="minseok lee <lms98923@naver.com>"

ARG JAR_FILE

COPY ${JAR_FILE} app.jar
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

# stage 2
FROM openjdk:17-alpine
VOLUME /tmp
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# esecute application
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.springmsa.SpringMsaApplication"]
