# Use a base image with OpenJDK (you can use the version that suits you)
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy your JAR file from the target folder to the container
COPY target/GolfTournamentQAP4-1.0-SNAPSHOT.jar /app/app.jar

# Expose the application port (make sure it's the same port your app runs on, typically 8080 for Spring Boot)
EXPOSE 8080

# Command to run your application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
