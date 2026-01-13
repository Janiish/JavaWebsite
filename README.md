# LeetCode Clone Backend

Spring Boot service scaffolded with Spring Web, Spring Data JPA, and MySQL driver.

## Prerequisites
- Java 17
- Maven 3.9+
- MySQL 8.x with database `leetcode_clone` and credentials configured in `src/main/resources/application.properties`.

## Setup
1. Create the database in MySQL:
   ```sql
   CREATE DATABASE leetcode_clone;
   ```
2. Update `spring.datasource.username` and `spring.datasource.password` in `src/main/resources/application.properties`.

## Run
```bash
mvn spring-boot:run
```

On first run, JPA will create the `users` table automatically (ddl-auto=update).
