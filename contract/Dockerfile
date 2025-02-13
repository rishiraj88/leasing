# Build
FROM gradle:8.12.1-jdk21-corretto AS build
WORKDIR /contract
COPY ./src build.gradle settings.gradle ./
RUN gradle build

LABEL maintainer="Rishi Raj"
LABEL version="1.0"
LABEL description="Dockerfile for Order-Manager::Gateway with JDK 21 and keycloak"

# Deploy
FROM amazoncorretto:8-alpine3.21-jre AS deploy
WORKDIR /contract
#RUN mkdir target
RUN mkdir -p /opt/contract/lib && mkdir -p /var/log/contract
RUN cp ./build/libs/contract-0.0.2-SNAPSHOT-plain.jar /opt/contract/lib/contract-0.0.2-SNAPSHOT-plain.jar
EXPOSE 8080
CMD ["java","-jar","/opt/rrlane/contract/lib/contract-0.0.2-SNAPSHOT-plain.jar"]
