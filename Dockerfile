# User official run time as parent
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring boot application's JAR file to the container
COPY target/demo.jar app.jar

# Expose the port that spring boot application will run on
EXPOSE 9000

# Run the Spring Boot application
ENTRYPOINT [ "java", "-jar", "app.jar" ]