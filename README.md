
# Products

This project based on the Spring Boot project and used packages:

-Spring Boot
-Spring Data
-Spring Security
-Maven
-H2 in-memory database


## Installation

### Database Configuration - In build h2 in-memory database

Access in-memory database :http://localhost:8082/h2_console

user: admin
password: password
    

The project is created with Maven.

### 3. Launch

To run the application locally:

>mvn clean install

>mvn spring-boot:run

commands run the application.

Application runs from localhost:8082/api/products

Basic authentication is in placed to access the service and swagger ui.

user: username
password: password

Swagger UI URL: http://localhost:8082/swagger-ui.html#/

For more information about operations and services please follow the swagger ui page

