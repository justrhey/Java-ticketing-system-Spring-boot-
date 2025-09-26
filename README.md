# Java Ticketing System (Spring Boot)

A ticketing system built with **Spring Boot**. This project allows users to create, track, and manage support tickets through a web interface.

---

## 🛠️ Table of Contents

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Getting Started](#getting-started)  
- [Usage](#usage)  
- [Project Structure](#project-structure)  
- [Contributing](#contributing)  
- [License](#license)  

---

## 🔍 Features

- Create new tickets  
- View list of tickets (status, priority, date created)  
- Update ticket status (e.g., Open, In Progress, Resolved)  
- Delete or archive tickets  
- Simple dashboard or filtering options (by status / priority)  

---

## ⚙️ Tech Stack

| Component | Details |
|-----------|---------|
| Language | Java |
| Framework | Spring Boot |
| Database | (e.g. MySQL / PostgreSQL / H2) |
| Build Tool | Maven |
| Frontend | (e.g. Thymeleaf, or REST API + JavaScript) |
| Others | Spring Data JPA, Spring Security (if used), Lombok (if used) |
  
---

## 🚀 Getting Started

### Prerequisites

- Java 11+ installed  
- Maven installed  
- Database set up (e.g. MySQL / PostgreSQL)  

### Installation

```bash
# Clone the repository
git clone https://github.com/justrhey/Java-ticketing-system-Spring-boot-.git

# Change directory
cd Java-ticketing-system-Spring-boot-

# Configure your database credentials (in application.properties or application.yml)
# Example (application.properties):
# spring.datasource.url=jdbc:mysql://localhost:3306/ticketdb
# spring.datasource.username=your_username
# spring.datasource.password=your_password

# Build the project
mvn clean install

# Run the app
mvn spring-boot:run
