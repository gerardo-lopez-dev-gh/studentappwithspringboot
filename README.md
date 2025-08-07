# Student Management Application with Spring Boot

A Spring Boot application for managing student records using MySQL database and JPA/Hibernate for data persistence.

## 🚀 Features

- **Student Management**: Create, read, update, and delete student records
- **MySQL Database Integration**: Persistent data storage with MySQL
- **JPA/Hibernate**: Object-relational mapping for database operations
- **Lombok Integration**: Reduced boilerplate code with annotations
- **Docker Support**: MySQL database containerization with Docker Compose
- **Testing Support**: H2 in-memory database for testing

## 🛠️ Technologies Used

- **Java 21**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **MySQL 8.0**
- **Lombok**
- **Maven**
- **Docker & Docker Compose**
- **H2 Database** (for testing)

## 📋 Prerequisites

- Java 21 or higher
- Maven 3.6+
- Docker and Docker Compose
- Git

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/com/studentappwithspringboot/
│   │   ├── StudentappwithspringbootApplication.java
│   │   ├── model/
│   │   │   └── Student.java
│   │   ├── repository/
│   │   │   └── StudentRepository.java
│   │   └── service/
│   │       ├── IStudentService.java
│   │       └── StudentService.java
│   └── resources/
│       ├── application.properties
│       └── logback-spring.xml
└── test/
    └── java/com/studentappwithspringboot/
        └── StudentappwithspringbootApplicationTests.java
```

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/gerardo-lopez-dev-gh/studentappwithspringboot.git
cd studentappwithspringboot
```

### 2. Start MySQL Database

Start the MySQL database using Docker Compose:

```bash
docker-compose up -d
```

This will create:
- MySQL container on port 3306
- Database: `student_db`
- User: `myuser`
- Password: `mypassword`

### 3. Build the Application

```bash
./mvnw clean compile
```

### 4. Run Tests

```bash
./mvnw test
```

### 5. Run the Application

```bash
./mvnw spring-boot:run
```

## 🗃️ Database Schema

The application uses a `students` table with the following structure:

| Column      | Type         | Description           |
|-------------|-------------|-----------------------|
| id          | BIGINT       | Primary key (auto-increment) |
| name        | VARCHAR      | Student's first name  |
| last_name   | VARCHAR      | Student's last name   |
| phone       | VARCHAR      | Phone number          |
| email       | VARCHAR      | Email address         |

## 🔧 Configuration

### Database Configuration

The application is configured to connect to MySQL. Key properties in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.jpa.hibernate.ddl-auto=none
```

### Testing Configuration

Tests use H2 in-memory database. Configuration in `application-test.properties`.

## 📝 API Endpoints

*Note: This application currently runs as a non-web application. To add REST endpoints, modify the `spring.main.web-application-type` property.*

## 🧪 Testing

Run the test suite:

```bash
./mvnw test
```

Tests use H2 in-memory database for fast execution without requiring external dependencies.

## 🐳 Docker Support

### Start MySQL Database

```bash
docker-compose up -d
```

### Stop MySQL Database

```bash
docker-compose down
```

### View Database Logs

```bash
docker-compose logs mysql
```

## 🔨 Development

### Code Formatting

The project uses Google Java Format for code formatting:

```bash
./mvnw com.coveo:fmt-maven-plugin:format
```

### Lombok

This project uses Lombok to reduce boilerplate code. Make sure your IDE has Lombok plugin installed.

## 📦 Build & Package

Create a JAR file:

```bash
./mvnw clean package
```

The generated JAR will be in the `target/` directory.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👨‍💻 Author

**Gerardo López**
- GitHub: [@gerardo-lopez-dev-gh](https://github.com/gerardo-lopez-dev-gh)

## 🆘 Troubleshooting

### Database Connection Issues

1. Ensure Docker is running and MySQL container is up:
   ```bash
   docker-compose ps
   ```

2. Check MySQL logs:
   ```bash
   docker-compose logs mysql
   ```

3. Verify database connectivity:
   ```bash
   docker exec -it mysql_container mysql -u myuser -p student_db
   ```

### Build Issues

1. Ensure Java 21 is installed:
   ```bash
   java -version
   ```

2. Clean and rebuild:
   ```bash
   ./mvnw clean compile
   ```
