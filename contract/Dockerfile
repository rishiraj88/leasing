# Build
# https://github.com/carlossg/docker-maven/blob/8cfe24baffa5b250f7bb2d31ce233fc28f3c4f20/amazoncorretto-21/Dockerfile
FROM gradle:jdk21-corretto-al2023 AS build
WORKDIR /contract
COPY ./src .
COPY ./src build.gradle settings.gradle ./
RUN gradle bootJar

# Deploy
FROM amazoncorretto:21-alpine3.21 AS deploy
WORKDIR /contract
RUN mkdir target

LABEL maintainer="Rishi Raj"
LABEL version="1.0.1-SNAPSHOT"
LABEL description="Dockerfile for Online Vehicle Leasing::Backend::API with JDK 21"

COPY --from=build /contract/build/libs/app-1.0.1-SNAPSHOT.jar /contract/target/
EXPOSE 8080
CMD [ "java", "-jar","target/app-1.0.1-SNAPSHOT.jar" ]

VOLUME ./mysql:/var/lib/mysql
VOLUME .String/docStringkerAny/mysql/init.sql:/docker-entrypoint-initdb.d/init.sql
