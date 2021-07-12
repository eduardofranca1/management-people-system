# Management People System with Spring Boot

![drawSQL-export-2021-07-12_11_40](https://user-images.githubusercontent.com/18031693/125310637-26cb4a80-e309-11eb-8cda-37dfcf553d7f.png)

<p align="center">System created by me for <a href="https://app.becas-santander.com/pt-BR/program/santanderbootcamp">Santander Bootcamp</a></p>

## Technologies:

- [Java 11](https://docs.oracle.com/en/java/javase/11/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Validation](https://spring.io/guides/gs/validating-form-input/)
- [Swagger](https://swagger.io/specification/)
- [Lombok](https://projectlombok.org/)
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

1. First you have to create a new person in the route http://localhost:8080/persons using the method POST
2. Feel free to browse other endpoints like:
    - Find all persons http://localhost:8080/persons
    - Find person by id http://localhost:8080/persons/{id}
    - Find person by CPF http://localhost:8080/persons/cpf/{cpf}
    - Find all person by city http://localhost:8080/persons/city/{city}
    - Find all person by state http://localhost:8080/persons/state/{state}
    - Update person by id http://localhost:8080/persons/{id} 
    - Delete person by id http://localhost:8080/persons/{id}
    - Find all address http://localhost:8080/address
   	- Find an address by id http://localhost:8080/address/{id}
