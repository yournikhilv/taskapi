# 📝 Task Management API

A **Task Management REST API** built with **Spring Boot**, **JWT Authentication**, and **MySQL**.

---

## 🚀 Features

- ✅ User Registration & Login with JWT Authentication
- ✅ Create, Read, Update, Delete (CRUD) Tasks
- ✅ Role-based access (USER & ADMIN)
- ✅ Secure REST API with Spring Security
- ✅ MySQL database integration
- ✅ Swagger API Documentation

---

## 🛠️ Tech Stack

| Layer       | Technology             |
| ----------- | ---------------------- |
| Backend     | Java 17, Spring Boot 3 |
| Security    | Spring Security + JWT  |
| Database    | MySQL 8                |
| Build Tool  | Maven                  |
| API Docs    | Swagger (OpenAPI)      |
| API Testing | Postman                |

---

## ⚙️ How to Run Locally

### Prerequisites

- Java 17+
- MySQL 8+
- Maven

---

### 1️⃣ Setup MySQL Database

```sql
CREATE DATABASE taskdb;
```

---

### 2️⃣ Configure Application

Open `src/main/resources/application.properties` and update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
jwt.secret=your_jwt_secret_key
```

---

### 3️⃣ Run the Application

```bash
mvn spring-boot:run
```

Backend runs at: `http://localhost:8080`

---

### 4️⃣ Swagger / OpenAPI Documentation

This project uses **SpringDoc OpenAPI** for interactive API documentation.

If not already present, make sure this dependency exists in `pom.xml`:

```xml
<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
	<version>2.8.8</version>
</dependency>
```

After starting the app, use the following URLs:

- Swagger UI: `http://localhost:8080/api/v1/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/api/v1/v3/api-docs`
- Swagger Config: `http://localhost:8080/api/v1/v3/api-docs/swagger-config`

To test secured endpoints in Swagger:

1. Call `POST /api/auth/login` and copy the JWT token from response.
2. Click **Authorize** in Swagger UI.
3. Enter: `Bearer <your_token>`
4. Execute protected endpoints like `/api/tasks`.

> If your `server.port` or `server.servlet.context-path` changes, update the URLs accordingly.

---

## 📡 API Endpoints

### 🔐 Auth Endpoints

| Method | Endpoint             | Description         | Auth Required |
| ------ | -------------------- | ------------------- | ------------- |
| POST   | `/api/auth/register` | Register a new user | ❌ No         |
| POST   | `/api/auth/login`    | Login & get JWT     | ❌ No         |

---

### 📋 Task Endpoints

| Method | Endpoint          | Description       | Auth Required |
| ------ | ----------------- | ----------------- | ------------- |
| GET    | `/api/tasks`      | Get all tasks     | ✅ Yes        |
| POST   | `/api/tasks`      | Create a new task | ✅ Yes        |
| GET    | `/api/tasks/{id}` | Get task by ID    | ✅ Yes        |
| PUT    | `/api/tasks/{id}` | Update a task     | ✅ Yes        |
| DELETE | `/api/tasks/{id}` | Delete a task     | ✅ Yes        |

> **Note:** Pass JWT token in the `Authorization` header as `Bearer <token>`

---

### 👑 Admin Endpoints

| Method | Endpoint     | Description     | Auth Required |
| ------ | ------------ | --------------- | ------------- |
| GET    | `/api/admin` | Admin dashboard | ✅ ADMIN only |

---

## 📂 Project Structure

```
taskapi/
├── src/
│   └── main/
│       ├── java/com/primetrade/taskapi/
│       │   ├── controller/
│       │   ├── config/
│       │   ├── dto/
│       │   ├── entity/
│       │   ├── repository/
│       │   ├── security/
│       │   └── service/
│       └── resources/
│           └── application.properties
└── pom.xml
```

---

## 🔒 Security

- Passwords are encrypted using **BCrypt**
- JWT tokens are used for stateless authentication
- All task endpoints are protected and require a valid JWT token
- Role-based access: **USER** and **ADMIN** roles supported

---

## 📈 Scalability Note

This project uses stateless JWT-based authentication, so API instances do not store session state in memory.

Current implementation characteristics that support scale:

- Layered architecture (`controller`, `service`, `repository`) for clear separation of concerns
- Database-backed persistence with Spring Data JPA and MySQL
- Stateless request authentication with JWT and Spring Security
- Externalized runtime configuration via `application.properties`

### Future Scalability Enhancements (When Needed)

If traffic and workload increase, this project can be extended with:

- Multiple API instances behind a load balancer
- Redis caching for frequently accessed data
- Asynchronous background workers for heavy operations
- Database performance tuning (indexes, query optimization, connection pool tuning)
- Centralized monitoring and tracing for capacity planning

---

## 👨‍💻 Author

**Nikhil V**
GitHub: [@yournikhilv](https://github.com/yournikhilv)