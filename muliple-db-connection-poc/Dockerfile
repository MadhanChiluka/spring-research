# Stage 1: Build the Spring Boot app with Maven
# Step 1: Use Maven image to build the Spring Boot application
FROM maven:3.8-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files to the container
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Step 2: Use OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Create a directory for the application
WORKDIR /app

# Copy the Spring Boot JAR file from the build stage
COPY --from=build /app/target/muliple-db-connection-poc-0.0.1-SNAPSHOT.jar /app/muliple-db-connection-poc-0.0.1-SNAPSHOT.jar

# Expose the application port (default for Spring Boot)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/muliple-db-connection-poc-0.0.1-SNAPSHOT.jar"]
