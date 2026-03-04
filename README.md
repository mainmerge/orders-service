# Orders Service

REST API для управления клиентами и заказами.

## Технологии

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Docker & Docker Compose
* Swagger (OpenAPI)

---

## Запуск проекта

### 1. Запуск через Docker

```bash
docker-compose up --build
```

Приложение будет доступно по адресу:

```
http://localhost:8081
```

Swagger UI:

```
http://localhost:8081/swagger-ui.html
```

---

## База данных

PostgreSQL запускается через Docker.

Параметры подключения:

* **Database:** orders
* **User:** admin
* **Password:** admin
* **Port:** 55432

---

## Эндпоинты API

### Customers

* `POST /customers` — создать клиента
* `GET /customers` — получить список клиентов
* `GET /customers/{id}` — получить клиента по id
* `PUT /customers/{id}` — обновить клиента
* `DELETE /customers/{id}` — удалить клиента

### Orders

* `POST /orders` — создать заказ
* `GET /orders` — получить список заказов
* `GET /orders/{id}` — получить заказ по id
* `PUT /orders/{id}` — обновить заказ
* `DELETE /orders/{id}` — удалить заказ
* `POST /orders/{id}/pay` — оплатить заказ
* `POST /orders/{id}/cancel` — отменить заказ

---

## Postman Collection

Для тестирования API можно использовать Postman коллекцию:

```
Orders Service.postman_collection.json
```

---

## Архитектура

Проект реализован по архитектуре **MVC**:

* **Controller** — обработка HTTP-запросов
* **Service** — бизнес-логика приложения
* **Repository** — доступ к данным через Spring Data JPA

---

## Автор

Aigerim Kaiyrzhanova
