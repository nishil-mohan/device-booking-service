# device-booking-service
Run spring boot application in local env and navigate to url for the API documentations.  
http://localhost:8081/swagger-ui/#/device-booking-controller/

What aspect of this exercise did you find most interesting?
1. Integration of External API (Fonoapi) considering error handling, resilence using circuit breaker
2. Optimistic locking and concurrency controls - handle simultaneous modifications to shared resources.
3. Liquibase for Database Changes: Using Liquibase to manage database schema changes and initial data insertion provides a structured way to handle database updates. It's interesting to see how the database evolves along with the application.
4. Swagger Documentation for better documenation of apis

What did you find most cumbersome?
1. Balancing Complexity and Simplicity: Striking the right balance between implementing a comprehensive solution and keeping the codebase simple and maintainable.
2. Managing Test Data
