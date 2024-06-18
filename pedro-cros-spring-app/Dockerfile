#FROM maven:3.8.5-openjdk-17
FROM maven:3.9.7-eclipse-temurin-22
#FROM maven:4.0.0-openjdk-22
#FROM maven:3.8.2-jdk-17

WORKDIR /bezkoder-app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run