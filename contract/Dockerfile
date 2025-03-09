# Build
FROM gradle:8.12.1-jdk21-corretto AS build
WORKDIR /contract
COPY ./src build.gradle settings.gradle ./
RUN gradle build

LABEL maintainer="Rishi Raj"
LABEL version="1.0.1"
LABEL description="Dockerfile for Online Vehicle Leasing::Backend::API with JDK 21"

# Deploy
FROM amazoncorretto:21-alpine3.21 AS deploy
WORKDIR /contract
#RUN mkdir target
RUN mkdir -p /opt/contract/lib && mkdir -p /var/log/contract
COPY ./build/libs/contract-1.0.1-SNAPSHOT-plain.jar /opt/contract/lib/contract-1.0.1-SNAPSHOT-plain.jar
EXPOSE 8080
CMD ["java","-jar","/opt/contract/lib/contract-1.0.1-SNAPSHOT-plain.jar"]

