FROM openjdk:8-jdk-slim
COPY ./build/libs/system-0.0.2-SNAPSHOT.jar /opt/server.jar
WORKDIR /opt
EXPOSE 9000
CMD ["java", "-jar", "/opt/server.jar"]