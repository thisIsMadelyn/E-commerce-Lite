# E-Commerce Lite - Spring Boot Backend

## 📋 Project Overview

**E-Commerce Lite** is a simplified online store backend API built with Spring Boot. It provides core e-commerce functionality including user management, product catalog, and order processing with inventory management.

### 🎯 Core Features

- **User Management**: Create and manage customer profiles
- **Product Catalog**: Full CRUD operations for products with inventory tracking
- **Order System**: Process orders with automatic stock validation and total calculation
- **Inventory Management**: Real-time stock updates with business logic enforcement
- **RESTful API**: Clean JSON API for frontend clients

## 🏗️ System Architecture

### Database Schema
```sql
users (id, email, name, created_date)
products (id, name, description, price, stock_quantity, created_date)
orders (id, user_id, total_amount, status, created_date)
order_items (id, order_id, product_id, quantity, price)
```

### Key Business Rules
- Orders automatically calculate totals based on product prices
- Stock quantities are validated before order processing
- Inventory is updated in real-time upon successful orders
- Orders cannot exceed available stock quantities

## 📁 Final Project Structure

```
src/main/java/com/ecommerce/ecommercelite/
├── config/
│   └── SwaggerConfig.java              # API documentation
├── controller/
│   ├── UserController.java             # User management endpoints
│   ├── ProductController.java          # Product catalog endpoints
│   └── OrderController.java            # Order processing endpoints
├── dto/
│   ├── CreateOrderRequest.java         # Order request creation 
│   └── OrderItemRequest.java           # Order item request
├── entity/
│   ├── User.java                       # User entity with orders relationship
│   ├── Product.java                    # Product entity with inventory
│   ├── Order.java                      # Order entity with total calculation
│   └── OrderItem.java                  # Order-item join entity
├── exception/
│   ├── GlobalExceptionHandler.java     # Custom exception for not found resources
│   ├── InsufficientStockException.java # Custom exception for stock issues
│   ├── OrderAlreadyCancelled.java      # Custom exception for cancelled orders
│   ├── OrderNotFoundException.java     # Custom exception for order not found
│   ├── ProductNotFoundException.java   # Custom exception for product not found
│   └── UserNotFoundException.java # Custom exception for stock issues
│ 
├── repository/
│   ├── UserRepository.java             # User data access
│   ├── ProductRepository.java          # Product data access
│   ├── OrderItemRepository.java        # OrderItem data access
│   └── OrderRepository.java            # Order data access
├── service/
│   ├── UserService.java                # User business logic
│   ├── ProductService.java             # Product business logic
│   └── OrderService.java               # Order processing logic
└── EcommerceLiteApplication.java       # Main application class

src/main/resources/
├── application.properties              # Database & server configuration
├── static/                             # Optional html resources
└── templates/                          # Optional template resources
    


```

## 🔧 Technical Implementation

### Technology Stack
- **Framework**: Spring Boot 3.2.x
- **Database**: MySQL with Spring Data JPA
- **Build Tool**: Maven
- **Java Version**: 17+
- **Validation**: Bean Validation API
- **Documentation**: SpringDoc OpenAPI

### Key Spring Boot Features Used
- Spring Data JPA for database operations
- Spring MVC for REST controllers
- Transaction management for data consistency
- Bean validation for input sanitization
- Repository pattern for data access abstraction

## 🚀 API Endpoints

### Users
- `GET /api/users` - List all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create new user
- `GET /api/users/{id}/orders` - Get user's order history

### Products
- `GET /api/products` - List all products (with pagination)
- `GET /api/products/{id}` - Get product details
- `POST /api/products` - Create new product (admin)
- `PUT /api/products/{id}` - Update product (admin)
- `DELETE /api/products/{id}` - Delete product (admin)

### Orders
- `GET /api/orders` - List all orders
- `GET /api/orders/{id}` - Get order details
- `POST /api/orders` - Create new order
- `PUT /api/orders/{id}/cancel` - Cancel order

## 💡 How It Works

### Order Processing Flow
1. **Request Validation**: Validate order items and quantities
2. **Stock Check**: Verify sufficient inventory for all items
3. **Price Calculation**: Calculate order total using current product prices
4. **Inventory Update**: Reduce stock quantities atomically
5. **Order Creation**: Save order with items in single transaction
6. **Response**: Return order confirmation with details

### Database Relationships
- **One-to-Many**: User → Orders
- **One-to-Many**: Order → OrderItems
- **Many-to-One**: OrderItem → Product
- **Bi-directional**: Orders can navigate to User and Products

### Business Logic Layer
- Service classes encapsulate complex business rules
- Transactional boundaries ensure data consistency
- Custom exceptions for business rule violations
- Automatic total calculations and inventory management

## 🛠️ Setup & Development

### Prerequisites
- Java 17+
- MySQL 8.0+
- Maven 3.6+

### Configuration
```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=username
spring.datasource.password=password

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Running the Application
```bash
mvn spring-boot:run
```

## 🧪 Testing Strategy

- Unit tests for service layer business logic
- Integration tests for repository layer
- MockMvc tests for controller endpoints
- Test data builders for easy test creation
- Transaction rollback for test isolation

## 📈 Learning Outcomes

By building this project, you'll master:
- Spring Boot application structure and best practices
- JPA entity relationships and mapping
- REST API design and implementation
- Transaction management and data consistency
- Business logic layer development
- Testing strategies for Spring applications
- Database design for real-world scenarios

---

**Ready to start coding?** This structure will give us a professional-grade Spring Boot application that demonstrates real e-commerce functionality while following industry best practices.