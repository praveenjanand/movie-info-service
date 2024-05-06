FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/movie-info-service-1-1.jar /app/movie-info-service-1-1.jar
EXPOSE 8081
CMD ["java", "-jar", "movie-info-service-1-1.jar"]
