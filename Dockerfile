FROM maven:3.8.3-openjdk-17
WORKDIR /app
COPY . .
RUN mvn clean install
WORKDIR /app/target
EXPOSE 8081
# Create log directory
# Create log directory
RUN mkdir -p /var/log/myapp

# Set permissions for the log directory
RUN chown -R jenkins:Kavindu Praneeth /var/log/myapp