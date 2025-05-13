FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY target/airesume-0.0.1-SNAPSHOT.jar airesume.jar
ENTRYPOINT ["java","-jar","/airesume.jar"]