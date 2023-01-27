FROM openjdk:11
RUN mkdir -p /opt/allane/contract/lib && mkdir -p /var/log/allane
ADD build/libs/contract-0.0.1-SNAPSHOT.jar /opt/allane/contract/lib/contract-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/allane/contract/lib/contract-0.0.1-SNAPSHOT.jar"]