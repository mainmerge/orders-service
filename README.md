# Orders Service

REST API для управления клиентами и заказами.

## Технологии

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Swagger (OpenAPI)

---

## Запуск проекта

### 1. Запуск через Docker

```bash
docker-compose up --build
```

Приложение будет доступно:

```
http://localhost:8080
```

Swagger:

```
http://localhost:8080/swagger-ui.html
```

---

## База данных

- DB: orders
- User: admin
- Password: admin
- Port: 55432

---

## Эндпоинты

### Customers
- POST /customers
- GET /customers
- GET /customers/{id}
- PUT /customers/{id}
- DELETE /customers/{id}

### Orders
- POST /orders
- GET /orders
- GET /orders/{id}
- PUT /orders/{id}
- DELETE /orders/{id}
- POST /orders/{id}/pay
- POST /orders/{id}/cancel