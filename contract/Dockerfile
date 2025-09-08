# Build
# https://github.com/carlossg/docker-maven/blob/8cfe24baffa5b250f7bb2d31ce233fc28f3c4f20/amazoncorretto-21/Dockerfile
FROM gradle:jdk21-corretto-al2023 AS build
WORKDIR /contract
COPY ./docker ./src build.gradle settings.gradle gradlew ./
RUN gradle wrapper
RUN chmod 777 gradlew
RUN ./gradlew bootJar
RUN echo ${PWD} && ls -lR


# Deploy
FROM amazoncorretto:21-alpine3.21 AS deploy

LABEL maintainer="Rishi Raj"
LABEL version="1.0.1-SNAPSHOT"
LABEL description="Dockerfile for Online Vehicle Leasing::Backend::API with JDK 21"

WORKDIR /contract
COPY --from=build /contract/build/libs/*.jar /contract/
RUN echo ${PWD} && ls -lR

EXPOSE 8080
CMD [ "ls", "-l" ]
CMD [ "java", "-jar","contract-1.0.1-SNAPSHOT.jar" ]

VOLUME ./leas:/var/lib/mysql
VOLUME ./docker/mysql/init.sql:/docker-entrypoint-initdb.d/init.sql