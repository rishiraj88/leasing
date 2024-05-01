FROM openjdk:17
RUN mkdir ~/contract && cd ~/contract
ADD ./src build.gradle gradlew settings.gradle ~/contract
WORKDIR .
RUN ./gradlew build
RUN mkdir -p /opt/rrlane/contract/lib && mkdir -p /var/log/rrlane
RUN cp ./build/libs/contract-0.0.2-SNAPSHOT-plain.jar /opt/rrlane/contract/lib/contract-0.0.2-SNAPSHOT-plain.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/rrlane/contract/lib/contract-0.0.2-SNAPSHOT-plain.jar"]