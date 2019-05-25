FROM openjdk:11-slim as build
WORKDIR /workspace/


COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw package -DskipTests

FROM openjdk:11-slim

ARG DEPENDENCY=/workspace

COPY --from=build ${DEPENDENCY}/target/uni7-loja-spring-0.0.1.jar .

ENTRYPOINT ["java","-jar","uni7-loja-spring-0.0.1.jar"]