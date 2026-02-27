# Microservices Lab – SE4010 (CTSE)

This project demonstrates a basic Microservices Architecture using Spring Boot, API Gateway, Docker, and Docker Compose.

## 🏗 Architecture Overview

The system consists of four services:

- **Item Service** (Port 8081)
- **Order Service** (Port 8082)
- **Payment Service** (Port 8083)
- **API Gateway** (Port 8080)

All client requests go through the API Gateway, which routes requests to the appropriate microservice.

---

## 📦 Project Structure
```
microservices-lab
│
├── item-service
├── order-service
├── payment-service
├── api-gateway
├── docker-compose.yml
└── README.md
```

---

## ⚙️ Technologies Used

- Java 17
- Spring Boot 3
- Spring Cloud Gateway
- Maven
- Docker
- Docker Compose

---

# 🚀 Running the Project

🔹 Step 1: Build JAR Files

From the root directory:

```
cd item-service
mvn clean package
cd ..

cd order-service
mvn clean package
cd ..

cd payment-service
mvn clean package
cd ..

cd api-gateway
mvn clean package
cd ..
```

🔹 Step 2: Run with Docker Compose

From the root folder:

```
docker compose build
docker compose up
```

Or run in detached mode:

```
docker compose up -d
```

🔹 Step 3: Verify Running Containers
```
docker ps
```
You should see 4 running containers:

- item-service
- order-service
- payment-service
- api-gateway

🌐 API Endpoints (Access via Gateway)

All requests must go through the API Gateway (Port 8080).

🔹 GET Requests
```
http://localhost:8080/items
```
```
http://localhost:8080/orders
```
```
http://localhost:8080/payments
```

🔹 POST Requests (Optional Bonus)
Add Item

- POST http://localhost:8080/items
```
{
  "name": "Headphones"
}
```
Create Order

- POST http://localhost:8080/orders
```
{
  "item": "Laptop",
  "quantity": 2,
  "customerId": "C001"
}
```
Process Payment

- POST http://localhost:8080/payments/process
```
{
  "orderId": 1,
  "amount": 1299.99,
  "method": "CARD"
}
```

🐳 Docker Configuration

Each microservice contains a Dockerfile:
```
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
```
Docker Compose creates a shared bridge network to allow container communication using service names.

🧪 Testing

The application was tested using:
```
Web Browser
Postman
Docker CLI
```
All services communicate successfully through the API Gateway.

👩‍💻 Author

**AMBEGODA A L A S K**
