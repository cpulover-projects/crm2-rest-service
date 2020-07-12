# CRM Rest Service (Spring Boot)

## Configuration
1. Spring Boot configurations with following dependencies: 
[[Reference]()]
   - Spring Web
   - Spring Boot DevTools
   - MySQL Driver
   - Lombok
2. Setup database
3. Configure application.properties for database 
[[application.properties]()]

---

## Spring Data JPA
1. Create Entity classes 
[[Customer]()]
2. Create Repository interfaces extend JpaRepository 
[[CutomerRepository]()]

#### Service Layer
3. Create Service interfaces 
[[CustomerService]()]
4. Create Service implementation classes 
[[CustomerServiceImpl]()]
   - Inject the Repository by constructor
   - Implementing interface methods by delegating to Reposity methods (auto defined by Spring Data JPA)
   - No need @Transactional for implement method since inject the Repository
5. Create Rest Controller 
[[CustomerRestController]()]
   - Inject the Service by constructor
   - Define endpoints

### Non-Service Layer
3. Create Rest Controller 
[[CustomerNoServiceRestController]()]
   - Inject the Repository by constructor
   - Define endpoints

---

## Notes/Tips
- Recommend inject by constructor instead of fields (for testing purposes)





