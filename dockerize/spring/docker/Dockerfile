FROM openjdk:8-jdk-alpine
COPY hello-world-1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
