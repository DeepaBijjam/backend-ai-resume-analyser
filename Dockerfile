FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app
RUN ls -la

COPY . .
RUN ls -la
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

#COPY src ./src

CMD ["./mvnw", "spring-boot:run"]