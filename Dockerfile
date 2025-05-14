FROM eclipse-temurin:21-jdk-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /target/airesume-0.0.1-SNAPSHOT.jar airesume.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","airesume.jar"]