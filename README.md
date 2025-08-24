# Spring Microservices Practice

This repository contains a **practical example of building microservices using Java Spring**. It is designed for learners and developers who want to understand and implement microservices architecture with Spring Boot.

## Features

* Demonstrates microservices architecture in Java Spring.
* Includes multiple services communicating via REST APIs.
* Uses **Spring Boot**, **Spring Cloud**, and **Docker Compose** for easy setup.
* Provides practical exercises to strengthen your understanding of microservices.

## Getting Started

### Prerequisites

* Java 17+
* Maven
* Docker & Docker Compose (optional, for running services in containers)

### Running the Application

1. Clone the repository:

```bash
git clone https://github.com/phanithlim/spring-microservice.git
cd spring-microservice
```

2. Build the services:

```bash
mvn clean install
```

3. Run each service individually (or use Docker Compose):

#### Option 1: Run individual services

```bash
cd service-name
mvn spring-boot:run
```

#### Option 2: Run all services using Docker Compose

```bash
docker-compose up
```

4. Access the services via their REST endpoints (check each service configuration for ports and endpoints).

## Tutorial

A step-by-step tutorial for this project is available on YouTube:
[Spring Microservices Java Spring Tutorial by Phanith Lim](https://www.youtube.com/watch?v=jdeSV0GRvwI&t=19605s)
