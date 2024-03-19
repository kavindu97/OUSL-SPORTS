#FROM maven:3.8.3-openjdk-17
#WORKDIR /app
#COPY . .
#RUN mvn clean install
#WORKDIR /app/target
#EXPOSE 8081
#
## Create log directory
## Create log directory
##RUN mkdir -p /var/log/myapp
###
#### Set permissions for the log directory
##RUN chown -R root:root /var/log/myapp
#
## Copy the Logback configuration file
#COPY logback.xml /app/
#CMD ["java", "-jar", "FinalProject-0.0.1-SNAPSHOT.jar"]
FROM maven:3.8.3-openjdk-17
WORKDIR /app
COPY . .
RUN mvn clean install
# Copy the Logback configuration file
COPY logback.xml /app/
EXPOSE 8081
CMD ["java", "-jar", "target/FinalProject-0.0.1-SNAPSHOT.jar"]