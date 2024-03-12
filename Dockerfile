FROM maven:3.8.3-openjdk-17
WORKDIR /app
COPY ./target/FinalProject-0.0.1-SNAPSHOT.jar /app
COPY ./test.sh /app
EXPOSE 8081
CMD ["java", "-jar", "FinalProject-0.0.1-SNAPSHOT.jar"]