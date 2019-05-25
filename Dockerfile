FROM adoptopenjdk/openjdk11:alpine as build
WORKDIR /workspace/loja


COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests

FROM michelav/wildfly-alpine

CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-c", "standalone-full.xml", "-bmanagement", "0.0.0.0"]
