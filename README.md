# Spring Boot Blog REST API

A simple and elegant REST API for a blogging platform built with Spring Boot, Spring Data JPA, and MySQL.

## Overview

This project provides a RESTful API for managing blog posts. Users can create, read, and manage posts with a clean separation of concerns using service and repository layers.

## Features

- ✅ Create new blog posts
- ✅ Retrieve all blog posts
- ✅ Retrieve a specific blog post by ID
- ✅ Update existing blog posts
- ✅ Delete blog posts
- ✅ Exception handling with custom error responses
- ✅ Data validation using DTOs (Data Transfer Objects)
- ✅ Clean architecture with Service and Repository layers

## Technology Stack

- **Java 21** - Programming language
- **Spring Boot 4.0.3** - Application framework
- **Spring Data JPA** - Database access layer
- **MySQL** - Database
- **Maven** - Build and dependency management
- **Lombok** - Reduce boilerplate code
- **Spring Web** - REST API support

## Project Structure

```
src/main/java/com/springboot/blog/
├── SpringbootBlogRestApiApplication.java   # Main application entry point
├── controller/
│   └── PostController.java                 # REST API endpoints
├── service/
│   ├── PostService.java                    # Service interface
│   └── impl/
│       └── PostServiceImpl.java             # Service implementation
├── entity/
│   └── Post.java                           # JPA entity (database model)
├── payload/
│   └── PostDto.java                        # Data Transfer Object
├── repository/
│   └── PostRepository.java                 # Spring Data JPA repository
├── exception/
│   └── ResourceNotFoundException.java       # Custom exception
└── utils/                                  # Utility classes (if any)
```

## Installation & Setup

### Prerequisites

- Java 21 or higher
- Maven 3.6+
- MySQL 8.0+

### Steps

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd springboot-blog-rest-api
   ```

2. **Create MySQL database**
   ```sql
   CREATE DATABASE blog_db;
   ```

3. **Configure database connection**
   
   Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

4. **Build the project**
   ```bash
   ./mvnw clean package -DskipTests
   ```

5. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

   The application will start on `http://localhost:8080`

## API Endpoints

### Post Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/posts` | Create a new post |
| GET | `/api/posts` | Get all posts |
| GET | `/api/posts/{id}` | Get a specific post by ID |
| PUT | `/api/posts/{id}` | Update a post |
| DELETE | `/api/posts/{id}` | Delete a post |

### Request/Response Examples

#### Create a Post
```bash
POST /api/posts
Content-Type: application/json

{
  "title": "My First Blog Post",
  "description": "This is the description of my first blog post",
  "content": "This is the content of my first blog post..."
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "title": "My First Blog Post",
  "description": "This is the description of my first blog post",
  "content": "This is the content of my first blog post..."
}
```

#### Get All Posts
```bash
GET /api/posts
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "title": "My First Blog Post",
    "description": "This is the description",
    "content": "This is the content..."
  }
]
```

#### Get Post by ID
```bash
GET /api/posts/1
```

**Response (200 OK):**
```json
{
  "id": 1,
  "title": "My First Blog Post",
  "description": "This is the description",
  "content": "This is the content..."
}
```

#### Update a Post
```bash
PUT /api/posts/1
Content-Type: application/json

{
  "title": "Updated Title",
  "description": "Updated description",
  "content": "Updated content..."
}
```

#### Delete a Post
```bash
DELETE /api/posts/1
```

**Response (204 No Content)**

## Error Handling

The API returns meaningful error responses:

```json
{
  "timestamp": "2026-03-03T10:30:00Z",
  "message": "Post not found with id: 999",
  "status": 404
}
```

### Common HTTP Status Codes

- `200 OK` - Successful GET request
- `201 Created` - Successful POST request
- `204 No Content` - Successful DELETE request
- `400 Bad Request` - Invalid input
- `404 Not Found` - Resource not found
- `500 Internal Server Error` - Server error

## Database Schema

### Posts Table

```sql
CREATE TABLE posts (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL UNIQUE,
  description TEXT NOT NULL,
  content LONGTEXT NOT NULL
);
```

## Running Tests

```bash
./mvnw test
```

## Build & Deployment

### Build JAR File
```bash
./mvnw clean package -DskipTests
```

The JAR file will be created at `target/springboot-blog-rest-api-0.0.1-SNAPSHOT.jar`

### Run JAR File
```bash
java -jar target/springboot-blog-rest-api-0.0.1-SNAPSHOT.jar
```

## Configuration

Edit `src/main/resources/application.properties` to customize:

- **Server Port**: `server.port=8080`
- **Database**: `spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password`
- **JPA/Hibernate**: `spring.jpa.hibernate.ddl-auto`, `spring.jpa.show-sql`

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Future Enhancements

- [ ] User authentication and authorization
- [ ] Pagination and sorting for posts
- [ ] Search functionality
- [ ] Comments system
- [ ] Categories/Tags for posts
- [ ] File upload for featured images
- [ ] API documentation with Swagger/OpenAPI

## Troubleshooting

### Issue: "Cannot find symbol method setId"
**Solution**: Ensure `PostDto` class has explicit getter/setter methods or is annotated with Lombok `@Data` annotation with proper annotation processor configuration.

### Issue: "Unable to connect to database"
**Solution**: 
- Verify MySQL is running
- Check database credentials in `application.properties`
- Ensure the database exists: `CREATE DATABASE blog_db;`

### Issue: "Port 8080 already in use"
**Solution**: Change the port in `application.properties`:
```properties
server.port=8081
```

## License

This project is open source and available under the MIT License.

## Author

Created with ❤️ for learning Spring Boot REST API development.

## Support

For issues and questions, please open an issue in the repository.

