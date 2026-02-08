Festival Management REST API

A. Project Overview
This project is a Spring Boot RESTful API developed to manage a music festival.
The system allows managing bands, stages, and performance slots while enforcing
business rules such as preventing time collisions on stages.

The project is based on previous assignments focused on JDBC, SOLID principles,
and advanced object-oriented programming, and was migrated into a RESTful API
with a layered architecture.


B. REST API Documentation

Endpoint List

| Endpoint | HTTP Method | Description |
|--------|------------|-------------|
| /health | GET | Check if API is running |
| /bands | GET | Retrieve all bands |
| /slots | POST | Create a new performance slot |


Sample Requests and Responses

GET /health
GET http://localhost:8080/health


Response:
Festival API is working
GET /bands
GET http://localhost:8080/bands
Response:

{
    "id": 1,
    "name": "Echo Pulse",
    "country": "USA",
    "genre": "Rock"
}

POST /slots
POST http://localhost:8080/slots
Request body:

{
    "bandId": 1,
    "stageId": 1,
    "start": "2026-07-01T18:00",
    "end": "2026-07-01T19:00"
}
Successful response:

Slot scheduled successfully
Error response (time collision):

{
  "error": "TIME_COLLISION",
  "message": "Stage time collision"
}


Postman Screenshots
All endpoints were tested using Postman.
Screenshots of successful requests and error cases are available
in the docs/screenshots folder.

C. Design Patterns
Singleton
The Singleton pattern is used for application-level configuration access.
It ensures that only one instance of the configuration is used throughout
the application.

Factory
The Factory pattern is used to encapsulate the creation of Slot objects.
This allows object creation without exposing implementation details and
supports future extension.

Builder
The Builder pattern is used to construct Slot objects with multiple parameters
using a fluent interface, improving readability and flexibility.

D. Component Principles
REP (Reuse/Release Equivalence Principle)
Reusable components such as repositories, services, and utilities are grouped
into stable packages.

CCP (Common Closure Principle)
Classes that change together are placed in the same package.

CRP (Common Reuse Principle)
The system avoids unnecessary dependencies between unrelated components.

E. SOLID & OOP Summary
SRP: Controllers handle HTTP requests, services handle business logic,
repositories handle database access.

OCP: New functionality can be added without modifying existing code.

LSP: All entities correctly extend a common base class.

ISP: Interfaces are small and focused.

DIP: Services depend on abstractions, not concrete implementations.

F. Database Schema
PostgreSQL is used as the relational database.
The schema includes related tables such as bands, stages, slots, and crew.
Foreign keys and constraints are used to maintain data integrity.
Sample data is included in the SQL script.

G. System Architecture Diagram
The system follows a layered architecture:

Controller → Service → Repository → Database

A UML diagram illustrating the architecture is provided in the docs folder.

H. How to Run the Application
Configure database credentials in application.properties

Make sure PostgreSQL is running

Run the Spring Boot application

Test the API using Postman

I. Reflection
This project helped me better understand how REST APIs are built using Spring Boot
and how SOLID principles and design patterns improve code structure.
The most challenging part was migrating from a console-based application
to a REST API, but it significantly improved my understanding of backend development.