# ---------- Build stage ----------
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom.xml first to leverage Docker cache
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source and build
COPY src ./src
RUN mvn clean package -DskipTests

# ---------- Runtime stage ----------
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the built JAR from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose Spring Boot port
EXPOSE 2000

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
