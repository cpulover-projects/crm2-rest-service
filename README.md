# Customer Relationships Management Rest API (Spring Boot)

## Endpoints
#### Service layer
- GET ```/api/customers```
- GET ```/api/customers/{id}```
- POST ```/api/customers```
- PUT ```/api/customers```
- DELETE ```/api/customers/{id}```
#### Non-service layer
Same as Service layer but replace ```api``` by ```api2```
#### Spring Data REST
- GET ```/magic-api/customers```
- GET ```/magic-api/customers?page={number}```: pages are zero-based
- GET ```/magic-api/customers?sort=lastName```
- GET ```/magic-api/customers?sort=firstName,desc```
- GET ```/magic-api/customers/{id}```
- POST ```/magic-api/customers```
- PUT ```/magic-api/customers/{id}```
- DELTE ```/magic-api/customers/{id}```

## Configuration
1. Spring Boot configurations with following dependencies: 
[[Reference](https://github.com/cpulover-practice/spring-boot)]
   - Spring Web
   - MySQL Driver
   - Spring Data JPA
   - Rest Repositories (Spring Data Rest)
   - Spring Boot DevTools (Optional)
   - Lombok (Optional)
2. Setup database
3. Configure application.properties for database 
[[application.properties](https://github.com/cpulover-projects/crm2-rest-service/blob/master/src/main/resources/application.properties)]

---

## Spring Data JPA
1. Create Entity classes 
[[Customer](https://github.com/cpulover-projects/crm2-rest-service/blob/master/src/main/java/com/cpulover/springboot/cruddemo/entity/Customer.java)]
2. Create Repository interfaces extend JpaRepository 
[[CutomerRepository](https://github.com/cpulover-projects/crm2-rest-service/blob/master/src/main/java/com/cpulover/springboot/cruddemo/repository/CustomerRepository.java)]

#### Service Layer
3. Create Service interfaces 
[[CustomerService](https://github.com/cpulover-projects/crm2-rest-service/blob/master/src/main/java/com/cpulover/springboot/cruddemo/service/CustomerService.java)]
4. Create Service implementation classes 
[[CustomerServiceImpl](https://github.com/cpulover-projects/crm2-rest-service/blob/master/src/main/java/com/cpulover/springboot/cruddemo/service/CustomerServiceImpl.java)]
   - Inject the Repository by constructor
   - Implementing interface methods by delegating to Reposity methods (auto defined by Spring Data JPA)
   - No need @Transactional for implement method since inject the Repository
5. Create Rest Controller 
[[CustomerRestController](https://github.com/cpulover-projects/crm2-rest-service/blob/master/src/main/java/com/cpulover/springboot/cruddemo/rest/CustomerRestController.java)]
   - Inject the Service by constructor
   - Define endpoints

#### Non-Service Layer
3. Create Rest Controller 
[[CustomerNoServiceRestController](https://github.com/cpulover-projects/crm2-rest-service/blob/master/src/main/java/com/cpulover/springboot/cruddemo/rest/CustomerNoServiceRestController.java)]
   - Inject the Repository by constructor
   - Define endpoints

---

## Spring Data REST
- Rest Controllers are not required
- Service layer is not required 
- Apply HATEOSA format for auto-defined endpoints
- Endpoints, pagination can be configured in 
[application.properties](https://github.com/cpulover-projects/crm2-rest-service/blob/master/src/main/resources/application.properties)
- Simple pluralized form
  - First charater of Entity type is lowercase
  - Then just add an "s"
  - For example: Customer -> ```<port>/customers```
- Specify plural name/path with ```@RepositoryRestResource(path="<name>")``` in the Repository
[[CustomerRepository](https://github.com/cpulover-projects/crm2-rest-service/blob/master/src/main/java/com/cpulover/springboot/cruddemo/repository/CustomerRepository.java)]
- Only use ID in the URL (not Response body) for PUT


## Notes/Tips
- Recommend inject by constructors instead of fields (for testing purposes)





