# Use official Java runtime
FROM openjdk:17-jdk-slim

# Working directory inside container
WORKDIR /app

# Copy the built jar from Maven target directory
COPY target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]