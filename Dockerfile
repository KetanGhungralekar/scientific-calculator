# Use official slim OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Create app directory
WORKDIR /app

# Copy built jar into the image
COPY target/scientific-calculator-1.0-SNAPSHOT.jar /app/calculator.jar

# Run the app (we call main class explicitly)
ENTRYPOINT ["java", "-cp", "calculator.jar", "com.calculator.App"]
