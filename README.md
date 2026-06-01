# Secure Login System - Full Stack Application

A full-stack authentication and task management system built using Spring Boot, React, PostgreSQL, Docker, and JWT-based security.

---

## Project Overview

This project implements a secure user authentication system with role-based protected APIs and a task management module. The system uses JWT tokens for stateless authentication and is fully containerized using Docker.

---

## Features

### Authentication
- User registration
- User login
- JWT token generation
- Stateless authentication using Spring Security

### Task Management
- Create tasks
- View user tasks
- Delete tasks
- User-specific data handling

### Security
- JWT-based authentication filter
- Protected backend endpoints
- CORS configured for frontend communication
- Stateless session management

---

## Tech Stack

### Backend
- Java 17+
- Spring Boot
- Spring Security
- JWT
- Hibernate / JPA
- PostgreSQL

### Frontend
- React (Vite)
- JavaScript
- Axios
- React Router

### DevOps
- Docker
- Docker Compose

---

## Project Structure

SecureLogin/
├── backend/
│   ├── src/
│   ├── Dockerfile
│   ├── pom.xml
│
├── frontend/
│   ├── src/
│   ├── package.json
│
├── docker-compose.yml
└── README.md

---

## Setup Instructions

### 1. Clone Repository

git clone https://github.com/your-username/secure-login.git
cd secure-login

---

### 2. Run with Docker

docker compose down
docker compose build --no-cache
docker compose up

---

## Application URLs

Frontend:
http://localhost:5173

Backend:
http://localhost:8080

Database:
PostgreSQL running inside Docker container

---

## API Endpoints

### Authentication

POST /api/v1/auth/register
POST /api/v1/auth/login

### Tasks (Protected Routes)

GET /api/v1/tasks
POST /api/v1/tasks
DELETE /api/v1/tasks/{id}

---

## Authentication Flow

1. User registers or logs in
2. Backend validates credentials
3. JWT token is generated and returned
4. Token is stored in browser localStorage
5. Token is sent in Authorization header for protected requests
6. Backend validates token using JWT filter
7. Access is granted to protected endpoints

---

## Database

- PostgreSQL is used as the database
- Hibernate handles ORM mapping
- Tables are auto-generated using ddl-auto update

---

## Docker Services

The project uses Docker Compose to manage services:

- Backend Spring Boot application
- PostgreSQL database service
- Frontend development server (optional depending on setup)

---

## Testing Flow

1. Register a new user
2. Login with credentials
3. Receive JWT token
4. Create tasks
5. View tasks
6. Delete tasks
7. Logout

---

## Notes

- Ensure Docker is running before starting the application
- Frontend runs on port 5173
- Backend runs on port 8080
- CORS is enabled for local frontend communication

---

## Author

Ronil Singh

---

## Future Improvements

- Task update functionality
- Role-based authorization (Admin/User)
- Production deployment (cloud hosting)
- UI improvements and responsive design