FROM openjdk:17
WORKDIR ~
RUN mkdir -p /opt/rrlane/contract/lib && mkdir -p /var/log/rrlane
ADD ./build/libs/contract-0.0.2-SNAPSHOT-plain.jar /opt/rrlane/contract/lib/contract-0.0.2-SNAPSHOT-plain.jar
#./gradlew clean build
#ADD build/libs/contract-0.0.2-SNAPSHOT.jar /opt/rrlane/contract/lib/contract-0.0.2-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/rrlane/contract/lib/contract-0.0.2-SNAPSHOT-plain.jar"]