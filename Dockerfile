FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/scientific-calculator-1.0-SNAPSHOT.jar calculator.jar
ENTRYPOINT ["java", "-jar", "calculator.jar"]
