FROM openjdk:17
RUN echo ~
RUN mkdir -p /opt/rrlane/lease/lib && mkdir -p /var/log/rrlane/lease/logs
WORKDIR /opt/rrlane/lease
ADD ./build/libs/contract-0.0.2-SNAPSHOT.jar /opt/rrlane/lease/lib/contract-0.0.2-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/rrlane/lease/lib/contract-0.0.2-SNAPSHOT.jar" ,"rrlane.leasing.LeasingmanagerApplication"]