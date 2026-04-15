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

| Layer       | Technology              |
|-------------|-------------------------|
| Backend     | Java 17, Spring Boot 3  |
| Security    | Spring Security + JWT   |
| Database    | MySQL 8                 |
| Build Tool  | Maven                   |
| API Docs    | Swagger (OpenAPI)       |
| API Testing | Postman                 |

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

### 4️⃣ View Swagger API Docs

Open in browser:
```
http://localhost:8080/api/v1/swagger-ui/index.html
```

---

## 📡 API Endpoints

### 🔐 Auth Endpoints

| Method | Endpoint               | Description         | Auth Required |
|--------|------------------------|---------------------|---------------|
| POST   | `/api/auth/register`   | Register a new user | ❌ No          |
| POST   | `/api/auth/login`      | Login & get JWT     | ❌ No          |

---

### 📋 Task Endpoints

| Method | Endpoint            | Description       | Auth Required |
|--------|---------------------|-------------------|---------------|
| GET    | `/api/tasks`        | Get all tasks     | ✅ Yes         |
| POST   | `/api/tasks`        | Create a new task | ✅ Yes         |
| GET    | `/api/tasks/{id}`   | Get task by ID    | ✅ Yes         |
| PUT    | `/api/tasks/{id}`   | Update a task     | ✅ Yes         |
| DELETE | `/api/tasks/{id}`   | Delete a task     | ✅ Yes         |

> **Note:** Pass JWT token in the `Authorization` header as `Bearer <token>`

---

### 👑 Admin Endpoints

| Method | Endpoint       | Description      | Auth Required  |
|--------|----------------|------------------|----------------|
| GET    | `/api/admin`   | Admin dashboard  | ✅ ADMIN only   |

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

## 👨‍💻 Author

**Nikhil V**
GitHub: [@yournikhilv](https://github.com/yournikhilv)