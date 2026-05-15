# 🌿 Rwanda Plant Marketplace

Modern multi-vendor plants marketplace platform built using Spring Boot, Thymeleaf, Bootstrap, Minia Admin Template, JWT Authentication, MinIO, and Docker.

---

# 📌 Project Overview

Rwanda Plant Marketplace is an Amazon/Jumia-style e-commerce platform designed for nurseries, plant businesses, florists, and gardening suppliers to sell:

- 🌱 Plants
- 🌸 Flowers
- 🌳 Trees
- 🪴 Pots
- 🧰 Gardening Tools
- 🌾 Seeds
- 🌿 Fertilizers

The platform supports:

- Multi-vendor marketplace management
- WhatsApp checkout workflow
- Vendor storefronts
- Product management
- Cloud object storage
- Admin analytics
- JWT authentication
- Responsive modern UI

---

# 🏗 Architecture

This project uses:

## Modular Monolith Architecture

```text
rw.ntaganira
│
├── auth
├── users
├── vendors
├── products
├── categories
├── carts
├── orders
├── payments
├── reviews
├── notifications
├── storage
├── admin
├── shared
│
├── config
├── security
└── exception
```

---

# ⚙️ Technology Stack

## Backend

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- JWT Authentication
- Thymeleaf
- Flyway
- Lombok

## Frontend

- Bootstrap 5
- Thymeleaf Layouts
- Minia Admin Template
- Responsive UI

## Database

### Development

- H2 Database
- H2 Console

### Production

- PostgreSQL

## Object Storage

- MinIO

## DevOps

- Docker
- Docker Compose

---

# 🔐 Authentication Features

Implemented:

- User Registration
- User Login
- JWT Authentication
- Role-Based Access Control (RBAC)
- Protected Routes

## Roles

```text
ADMIN
VENDOR
CUSTOMER
```

---

# 🛒 Marketplace Features

## Customer Features

- Browse products
- Product search
- Product details page
- Shopping cart
- WhatsApp checkout
- Vendor storefronts

## Vendor Features

- Vendor registration
- Vendor profile
- Product management
- Inventory management
- Image uploads
- Vendor storefront

## Admin Features

- Vendor approvals
- Marketplace moderation
- Dashboard analytics
- Product management

---

# ☁️ MinIO Storage

Used for:

- Product images
- Vendor logos
- Profile photos
- Marketplace banners

---

# 📦 WhatsApp Checkout Workflow

MVP payment strategy uses WhatsApp ordering.

## Checkout Flow

```text
Add To Cart
→ Checkout
→ Save Order
→ Generate WhatsApp Message
→ Redirect To Vendor WhatsApp
```

Generated URL format:

```text
https://wa.me/{vendorPhoneNumber}?text={encodedMessage}
```

---

# 🗃 Database Strategy

## Development

H2 in-memory database with console enabled.

H2 Console:

```text
http://localhost:8080/h2-console
```

## Production

PostgreSQL

Database migrations handled using Flyway.

---

# 🐳 Docker Setup

## Start Infrastructure

```bash
docker compose up -d
```

Services:

| Service | Port |
|---|---|
| PostgreSQL | 5432 |
| MinIO API | 9000 |
| MinIO Console | 9001 |

---

# ☁️ MinIO Access

## MinIO Console

```text
http://localhost:9001
```

Credentials:

```text
Username: minioadmin
Password: minioadmin
```

---

# ⚠️ IMPORTANT MINIO NOTE

Use:

```text
http://localhost:9000
```

for Spring Boot API integration.

Use:

```text
http://localhost:9001
```

ONLY for browser admin console.

---

# 🚀 Running The Application

## 1. Clone Project

```bash
git clone https://github.com/your-username/plant-marketplace.git
```

---

## 2. Start Docker Services

```bash
docker compose up -d
```

---

## 3. Run Spring Boot

```bash
mvn spring-boot:run
```

---

# 🔧 Build Commands

## Clean Build

```bash
mvn clean install
```

## Run Tests

```bash
mvn test
```

---

# 📁 Flyway Migrations

Migration files located at:

```text
src/main/resources/db/migration
```

---

# 🎨 UI Design Inspiration

Inspired by:

- Amazon
- Jumia
- Alibaba

With eco-friendly green branding for nursery and gardening businesses.

---

# 🌱 Current Modules

Implemented modules:

- ✅ Authentication
- ✅ Security
- ✅ Shared Infrastructure
- ✅ Products
- ✅ Categories
- ✅ Vendors
- ✅ Storage
- ✅ Cart
- ✅ Orders
- ✅ WhatsApp Checkout
- ✅ Marketplace UI

---

# 🔥 Upcoming Features

Planned roadmap:

- Product reviews
- Wishlist
- Order tracking
- Notifications
- Vendor analytics
- Mobile app
- Payment gateway integration
- Delivery management
- AI plant recommendations

---

# 👨‍💻 Development Standards

This project follows:

- Clean Architecture
- DTO Pattern
- Service Layer Pattern
- Repository Pattern
- Constructor Injection
- Modular Monolith Principles
- Enterprise Java Standards

---

# 👨‍💻 Author

## Heritier Ntaganira

NIHO TECHNOLOGIES LTD

Rwanda 🇷🇼

---

# 📄 License

Private Enterprise Project

Copyright © 2026 NIHO TECHNOLOGIES LTD
