# Management People System with Spring Boot

![drawSQL-export-2021-07-12_16_29](https://user-images.githubusercontent.com/18031693/125344948-4f197000-e32e-11eb-88a6-914e92ece416.png)

<p align="center">System created by me for <a href="https://app.becas-santander.com/pt-BR/program/santanderbootcamp">Santander Bootcamp</a></p>

## Technologies:

- [Java 11](https://docs.oracle.com/en/java/javase/11/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Validation](https://spring.io/guides/gs/validating-form-input/)
- [Swagger](https://swagger.io/specification/)
- [Lombok](https://projectlombok.org/)
- [MapStruct](https://mapstruct.org/)
- [MySQL](https://www.mysql.com/)

## Built with:

- [Spring Initializr](https://start.spring.io/)
- [Maven](https://maven.apache.org/index.html)

## Tools:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/promo/)
- [Postman](https://www.postman.com/)
- [MySQL Workbench - For Prod](https://www.mysql.com/products/workbench/)
- [H2 - For Test](http://localhost:8080/h2-console/)

## How can I test the endpoints?

Open your preferred IDEA: 

- Maven will download the dependencies 
- Open the ManagementPeopleSystemApplication class by clicking on the Run option 
- Or if you have Maven installed, you can use the command: **mvn spring-boot:run** on your console 

You can use  [Insomnia](https://insomnia.rest/) or [Postman](https://www.postman.com/) to check the endpoints

1. First you have to create a new user in the route http://localhost:8080/persons using the method POST

![create user](https://user-images.githubusercontent.com/18031693/125319921-98a79200-e311-11eb-877c-d7830b58d92a.png)

2. Feel free to browse other endpoints like:
    - Find all persons http://localhost:8080/users
    - Find user by id http://localhost:8080/users/{id}
    - Find user by CPF http://localhost:8080/users/cpf/{cpf}
    - Find all user by city http://localhost:8080/users/city/{city}
    - Find all user by state http://localhost:8080/users/state/{state}
    - Update user by id http://localhost:8080/users/{id} 
    - Delete user by id http://localhost:8080/users/{id}
    - Find all address http://localhost:8080/address
   - Find an address by id http://localhost:8080/address/{id}
