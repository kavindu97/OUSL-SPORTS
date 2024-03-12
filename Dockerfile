FROM maven:3.8.3-openjdk-17
WORKDIR /app
COPY . .
RUN mvn clean install
WORKDIR /app/target
EXPOSE 8081
CMD ["java", "-jar", "FinalProject-0.0.1-SNAPSHOT.jar"]