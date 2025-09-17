# Microservices Learning Project

This project is for learning and practicing microservices architecture with modern tools and technologies.

## Overview
The system consists of several independent services communicating via both REST (synchronous) and Kafka (asynchronous). Each service has its own database.

## Services
- API Gateway: routes client requests to services.
- Identity Service: Keycloak for authentication and authorization.
- Product Service: manages products, uses MySQL with Flyway.
- Order Service: manages orders, uses MongoDB, publishes events to Kafka.
- Notification Service: consumes Kafka events and sends mock notifications.

## Communication
- Synchronous: API Gateway to Product Service and Order Service.
- Asynchronous: Order Service publishes events, Notification Service consumes them.

## Tech Stack
- Java 21, Spring Boot 3
- Spring Cloud Gateway
- Docker, Docker Compose
- MySQL with Flyway
- MongoDB
- Apache Kafka
- Keycloak
- Kubernetes (optional)