# Classic Models Backend

A Spring Boot REST API that powers the **Classic Models Management System**. The application exposes RESTful endpoints for managing customers, employees, offices, orders, payments, products, and product lines while interacting with a MySQL database using Spring Data JPA.

The backend is designed using a layered architecture to promote maintainability, scalability, and separation of concerns.

---

## 🌐 Live API

**Base URL**

```
https://productline-backend-production.up.railway.app/api
```

---

## ✨ Features

- RESTful API design
- Customer management
- Employee management
- Office management
- Product management
- Product line management
- Order management
- Payment management
- Dashboard data endpoints
- MySQL database integration
- Layered architecture
- Environment-based configuration
- Cloud deployment on Railway

---

## 🛠 Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 21 | Programming Language |
| Spring Boot 3 | Backend Framework |
| Spring Web | REST APIs |
| Spring Data JPA | Database access |
| MySQL | Relational Database |
| Maven | Dependency Management |
| Lombok | Boilerplate reduction |
| Railway | Cloud Deployment |

---

## 📁 Project Structure

```
src/
└── main/
    ├── configuration/   # Application configuration
    ├── controller/      # REST API controllers
    ├── DTOs/            # Data Transfer Objects
    ├── entities/        # JPA entities
    ├── repository/      # Spring Data repositories
    ├── service/         # Business logic
    ├── ClassicmodelsApplication.java
    └── resources/
        └── application.properties
```

---

## 🏛 Architecture

The project follows a layered architecture:

```
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
MySQL Database
```

This separation improves maintainability, testability, and scalability.

---

## 📌 Available API Resources

The application exposes endpoints for:

- Customers
- Products
- Product Lines
- Orders
- Payments
- Employees
- Offices
- Dashboard

All endpoints are accessible under:

```
/api/*
```

---

## ⚙️ Configuration

The application uses environment variables for database configuration.

```properties
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
```

This allows secure deployment without exposing database credentials.

---

## 🚀 Running Locally

### Clone the repository

```bash
git clone <repository-url>
cd classicmodels-backend
```

### Configure the database

Create a MySQL database and update your environment variables or `application.properties`.

### Run the application

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

The API will be available at

```
http://localhost:8080/api
```

---

## ☁️ Deployment

The backend is deployed on **Railway**.

Deployment includes:

- Cloud-hosted MySQL database
- Environment variable configuration
- Automatic deployments from GitHub
- Production-ready REST API

---

## 🔮 Future Improvements

Potential enhancements include:

- Authentication and Authorization (JWT)
- API Documentation with Swagger/OpenAPI
- Validation and Global Exception Handling
- Unit and Integration Testing
- Docker support
- CI/CD pipeline
- Role-based access control

---

## 👨‍💻 Author

**Joy Leila Kendi**

Bachelor of Science in Computer Science

GitHub: https://github.com/Kendi-prog