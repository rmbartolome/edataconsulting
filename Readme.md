# Spring Boot, JPA, Hibernate Rest API Test for edataconsulting

Build Restful CRUD API for a simple crud USERS application using Spring Boot, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 2.1.8

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/rmbartolome/edataconsulting.git
```
**2. Build and run the app using maven**

```bash
mvn package
java -jar target/rest-services-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8082>.

## Explore Rest APIs

The app defines following CRUD APIs.

    users
    GET /users/all
    
    GET /users/{id}
    
    POST /users/add/{id}
    
    PUT /users/add/{id}
   
    DELETE /users/delete/{id}
    
    auth
    POST /login

You can test them using postman or any other rest client or using our front_test:
https://github.com/rmbartolome/front_test.git
