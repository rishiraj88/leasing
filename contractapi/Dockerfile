# Build
# https://github.com/carlossg/docker-maven/blob/8cfe24baffa5b250f7bb2d31ce233fc28f3c4f20/amazoncorretto-21/Dockerfile
FROM gradle:jdk21-corretto-al2023 AS build
WORKDIR /app
COPY ./src build.gradle.kts settings.gradle.kts ./
RUN gradle bootJar

# Deploy
FROM amazoncorretto:21-alpine3.21 AS deploy
WORKDIR /contractapi
RUN mkdir target

LABEL maintainer="Rishi Raj"
LABEL version="1.0.1-SNAPSHOT"
LABEL description="Dockerfile for Vehicle Leasing Portal :: API :: with Kotlin 1.9.25 (JDK 21 API level)"

COPY --from=build /app/build/libs/contractapi-1.0.1-SNAPSHOT.jar /app/target/
EXPOSE 8080
CMD [ "java", "-jar", "target/contractapi-1.0.1-SNAPSHOT.jar" ]

VOLUME ./mysql:/var/lib/mysql
VOLUME .String/docStringkerAny/mysql/init.sql:/docker-entrypoint-initdb.d/init.sql
