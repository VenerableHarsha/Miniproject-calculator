# Use official Java runtime
FROM eclipse-temurin:17

# Working directory inside container
WORKDIR /app

# Copy the built jar from Maven target directory
COPY Calculator/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]