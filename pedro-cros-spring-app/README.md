# Superprof - 
## Desarrollo de Aplicaciones Web
## Proyecto Integrado
# Pedro Jesús Cros Pérez
## Used technology
### Backend
- . Ecosistema Spring
- Spring Boot
- Spring Boot DevTools
- Spring Data JPA
- Thymeleaf
- Spring Security
- Lombok
- Maven
####
- Testing
  - JUnit and Mockito
  - SonarQube

### Frontend
- JavaScript + HTML + CSS(Bootstrap)
- JQuery
- SweetAlert2

### DevOps
- Docker
- Docker Compose

### Data base
- MySQL
- PostgreSQL



# How to run
## Docker Compose Spring Boot and MySQL example

## Prerequisites
#### Insert into ``superprof_db.roles``
```
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_TEACHER');
INSERT INTO roles(name) VALUES('ROLE_STUDENT');
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_UNASSIGNED');
```

## Run the System
We can easily run the whole with only a single command:
```bash
docker compose up
```

Docker will pull the MySQL and Spring Boot images (if our machine does not have it before).

The services can be run on the background with command:
```bash
docker compose up -d
```

## Stop the System
Stopping all the running containers is also simple with a single command:
```bash
docker compose down
```

If you need to stop and remove all containers, networks, and all images used by any service in <em>docker-compose.yml</em> file, use the command:
```bash
docker compose down --rmi all
```

## Run SonarQube with Docker
```
mvn spring-boot:run -Dspring-boot.run.profiles=dev -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=dev"
```

## Run Spring Boot application
```bash
mvn spring-boot:run
```

