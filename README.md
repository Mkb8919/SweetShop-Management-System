🍬 Sweet Shop Management System

A full-stack Sweet Shop Management System built as part of the Incubyte AI Kata Assessment.
The application allows users to register, log in, view available sweets, purchase items, and enables admin users to manage inventory securely.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Features
🔐 Authentication

User registration and login

JWT-based authentication

Role-based authorization (USER / ADMIN)

🍭 Sweet Management

Add new sweets (Admin only)

View all sweets

Search sweets by name, category, or price range

Update sweet details (Admin only)

Delete sweets (Admin only)

📦 Inventory Management

Purchase sweets (quantity decreases)

Restock sweets (Admin only)

Purchase button disabled when stock is zero
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🛠️ Tech Stack
Backend

Java 21

Spring Boot

Spring Security + JWT

Spring Data JPA

MySQL (Relational Database)

Maven

Frontend

React.js

Axios

HTML / CSS

Tools

IntelliJ IDEA (Backend)

VS Code (Frontend)

Postman (API testing)

Git & GitHub (Version Control)
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🏗️ Project Architecture
Frontend (React)
   |
   |  HTTP Requests (Axios)
   |
Backend (Spring Boot REST API)
   |
   |  JPA / Hibernate
   |
Database (MySQL)

🔗 API Endpoints
Auth APIs

POST /api/auth/register – Register new user

POST /api/auth/login – Login & get JWT token

Sweet APIs (Protected)

POST /api/sweets – Add sweet (Admin)

GET /api/sweets – Get all sweets

GET /api/sweets/search – Search sweets

PUT /api/sweets/{id} – Update sweet (Admin)

DELETE /api/sweets/{id} – Delete sweet (Admin)

Inventory APIs (Protected)

POST /api/sweets/{id}/purchase – Purchase sweet

POST /api/sweets/{id}/restock – Restock sweet (Admin)
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Setup Instructions
Backend Setup

Clone repository:

git clone <your-repo-url>


Configure MySQL:

spring.datasource.url=jdbc:mysql://localhost:3306/sweetshop
spring.datasource.username=root
spring.datasource.password=yourpassword


Run backend:

mvn spring-boot:run


Backend runs on:

http://localhost:8080

Frontend Setup
cd sweetshop-frontend
npm install
npm start


Frontend runs on:

http://localhost:3000
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧪 Testing

Backend APIs tested using Postman

Authentication & authorization verified using JWT tokens

CRUD and inventory flows manually tested

(Test automation planned / partially implemented as part of TDD approach)

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🤖 My AI Usage 
AI Tool Used

ChatGPT (OpenAI)

How I Used ChatGPT

I used ChatGPT as an AI-assisted development tool throughout this project to:

Generate initial boilerplate code for controllers, services, entities, and security configuration

Understand and implement JWT-based authentication using Spring Security

Debug compilation, dependency, and runtime errors

Structure RESTful APIs following best practices

Assist in frontend component planning and API integration

Improve code readability and maintainability

All AI-generated suggestions were reviewed, understood, and modified manually before integration.

Reflection on AI Usage

ChatGPT significantly improved my productivity and helped me debug issues faster while maintaining full control over the implementation.
I consider it a pair-programming assistant, not a replacement for my own understanding or effort.

The final codebase is my own work, created responsibly and transparently in compliance with the assessment guidelines.
