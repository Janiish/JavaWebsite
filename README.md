# Java Full-Stack LeetCode-like (College Project)

Spring Boot + Thymeleaf app on Java 21, with REST APIs and server-rendered pages.

## Requirements
- Java 21 (LTS)
- Maven 3.9+
- MySQL 8.x with database `leetcode_clone`

## Setup
1. Create the database in MySQL:
    ```sql
    CREATE DATABASE leetcode_clone;
    ```
2. Configure credentials in [src/main/resources/application.properties](src/main/resources/application.properties).
    - `spring.datasource.url=jdbc:mysql://localhost:3306/leetcode_clone`
    - `spring.datasource.username=...`
    - `spring.datasource.password=...`

## Build & Run
- Build:
   ```powershell
   mvn -q -DskipTests package
   ```
- Run:
   ```powershell
   mvn spring-boot:run
   ```

## REST Endpoints
- Health: `GET /api/health`
- Users:
   - `GET /api/users?page=0&size=10` — list (paged)
   - `POST /api/users` — create
   - `GET /api/users/{id}` — get by id
   - `PATCH /api/users/{id}` — update (partial)
   - `DELETE /api/users/{id}` — delete

## Thymeleaf Pages
- List users: `/users` — [src/main/resources/templates/users.html](src/main/resources/templates/users.html)
- Create user: `/users/new` — [src/main/resources/templates/user-form.html](src/main/resources/templates/user-form.html)
- Edit user: `/users/{id}/edit`

## Code Map
- Entry: [src/main/java/com/example/leetcodeclone/LeetcodeCloneApplication.java](src/main/java/com/example/leetcodeclone/LeetcodeCloneApplication.java)
- Entity: [src/main/java/com/example/leetcodeclone/model/User.java](src/main/java/com/example/leetcodeclone/model/User.java)
- Repository: [src/main/java/com/example/leetcodeclone/repository/UserRepository.java](src/main/java/com/example/leetcodeclone/repository/UserRepository.java)
- Service: [src/main/java/com/example/leetcodeclone/service/UserService.java](src/main/java/com/example/leetcodeclone/service/UserService.java)
- REST: [src/main/java/com/example/leetcodeclone/web/UserController.java](src/main/java/com/example/leetcodeclone/web/UserController.java)
- MVC: [src/main/java/com/example/leetcodeclone/web/UserPageController.java](src/main/java/com/example/leetcodeclone/web/UserPageController.java)
- Health: [src/main/java/com/example/leetcodeclone/web/HealthController.java](src/main/java/com/example/leetcodeclone/web/HealthController.java)

## Notes
- On first run, JPA will create the `users` table automatically (`ddl-auto=update`).
- Ensure MySQL is running locally and accessible with your credentials.
