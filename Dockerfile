# Use a base image with OpenJDK
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy your JAR file from the target folder to the container
COPY target/GolfTournamentQAP4-1.0-SNAPSHOT.jar /app/app.jar

# Expose the application port
EXPOSE 8080

# Command to run your application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
