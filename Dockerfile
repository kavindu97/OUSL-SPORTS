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
#FROM maven:3.8.3-openjdk-17
#WORKDIR /app/target
#COPY . .
#RUN mvn clean install
## Copy the Logback configuration file
##COPY logback.xml /srv/myapp/
#
## Define a volume for the log files
#VOLUME /srv/myapp/
#
## Configure logback to save log files in the mounted volume
#COPY logger-config.xml /src/main/resources/logger-config.xml
#EXPOSE 8081
#CMD ["java", "-jar", "target/FinalProject-0.0.1-SNAPSHOT.jar"]

FROM maven:3.8.3-openjdk-17
WORKDIR /app
COPY . .

# Build the application
RUN mvn clean install

# Define a volume for the log files
VOLUME /srv/myapp/

EXPOSE 8081
CMD ["java", "-Dlogback.configurationFile=/srv/myapp/logger-config.xml", "-jar", "target/FinalProject-0.0.1-SNAPSHOT.jar"]

#FROM maven:3.8.3-openjdk-17
#WORKDIR /app
#COPY . .
#
## Build the application
#RUN mvn clean install
#
## Define a volume for the log files
#VOLUME /srv/myapp/
#
## Copy the logger configuration file to the mounted folder
#CMD ["sh", "-c", "cp /src/main/resources/logger-config.xml /srv/myapp/ && java -Dlogback.configurationFile=/srv/myapp/logger-config.xml -jar target/FinalProject-0.0.1-SNAPSHOT.jar"]
#FROM maven:3.8.3-openjdk-17
#WORKDIR /app
#COPY . .
#
## Build the application
#RUN mvn clean install
#
## Copy the logger configuration file to the mounted folder
#CMD ["sh", "-c", "cp /src/main/resources/logger-config.xml /srv/myapp/ && java -Dlogback.configurationFile=/srv/myapp/logger-config.xml -jar target/FinalProject-0.0.1-SNAPSHOT.jar"]