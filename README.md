# 🧑‍💻 Employee Management System (Spring Boot + Thymeleaf CRUD)

This is a full-stack employee management application built with Spring Boot 3. It provides both a complete RESTful API and a server-side rendered Web UI using Thymeleaf for full CRUD functionality.

The application uses Spring Data JPA with an H2 in-memory database for rapid development and features robust centralized error handling (e.g., custom 404 responses).


## 🗝️ Key Features
- Dual Interface: REST API (JSON) and Web UI (Thymeleaf/Bootstrap 5).
- Data Integrity: Uses Jakarta Validation (@Valid) on the Employee model.
- Layered Architecture: Clear separation of Controller, Service, and Repository layers.

## 🛠️ Technology Stack
| Component | Technology | Description |
|---|---|---|
| Backend | Spring Boot 3.x | Core application framework. |
| Persistence | Spring Data JPA | Simplified database interactions. |
| Database | H2 Database | In-memory data persistence. |
| Web UI | Thymeleaf & Bootstrap 5 | Server-side rendering and styling. |
| Language | Java 17+ | Core programming language. |

## 🚀 Getting Started
Prerequisites
- Java Development Kit (JDK 17+)
- Maven

Run Locally
1. Clone the Repository:
   git clone [THIS REPOSITORY_URL] cd EmployeeManagementSystem
2. Build and Run:
   mvn clean install & mvn spring-boot:run

The application will start on PORT 8080 (http://localhost:8080)

## 🔗 Usage and Endpoints
1. Web Application (Thymeleaf UI)
   Access the full employee dashboard and management forms:

| Path | Description |
|---|---|
| [Backend] (http://localhost:8080/app/employees) | View and manage all employees (full CRUD). |

2. REST API Endpoints (Programmatic access for CRUD operations)
   | HTTP Method | Path | Description |
   |---|---|---|
   | GET | /api/employees | Get all employees. |
   | GET | /api/employees/{id} | Get a single employee. |
   | POST | /api/employees | Create a new employee (requires JSON body). |
   | PUT | /api/employees/{id} | Update an existing employee (requires JSON body). |
   | DELETE | /api/employees/{id} | Delete an employee. |


## 🪪 License

Distributed under the MIT License.
