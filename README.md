# Cipher Terminal

A lightweight **Caesar Cipher REST API** built with **Java 21** and **Spring Boot**. Cipher Terminal exposes HTTP endpoints to encrypt and decrypt text using a fixed shift-based substitution cipher.

The project demonstrates core Spring Boot backend concepts, including REST controllers, constructor-based dependency injection, service-layer business logic, and JSON responses.

## Features

- **Text encryption** using a Caesar cipher with a fixed shift of 5.
- **Text decryption** by applying the inverse shift.
- **Case preservation** — uppercase and lowercase letters retain their case.
- **Non-alphabetic character preservation** — spaces, numbers, and punctuation remain unchanged.
- **REST API** — simple GET endpoints for encryption and decryption.
- **Layered design** — separates HTTP request handling from cipher logic.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Spring Boot 4.1.1 | Application framework |
| Spring WebMVC | REST API endpoints |
| Maven | Build and dependency management |
| Spring Boot DevTools | Development-time support |

## How the Cipher Works

Cipher Terminal uses the **Caesar cipher**, a substitution cipher that shifts each alphabetic character by a fixed number of positions.

The configured shift is **5**:

- Encryption moves each letter 5 positions forward.
- Decryption moves each letter 5 positions backward.
- The operation wraps around the alphabet (for example, `X` becomes `C` when encrypted).
- Letter case is preserved, and non-letter characters are copied unchanged.

### Example

| Input | Operation | Output |
|---|---|---|
| `Hello World` | Encrypt | `Mjqqt Btwqi` |
| `Mjqqt Btwqi` | Decrypt | `Hello World` |

> **Security note:** A Caesar cipher is a classical educational cipher, not modern cryptographic protection. Do not use it to protect passwords, personal information, or sensitive data.

## Project Structure

The Spring Boot Maven application is inside the `Cipher Terminal/` directory.

```text
Cipher-Terminal-Project/
├── README.md
├── encrypt.png
├── decrypt.png
└── Cipher Terminal/
    ├── pom.xml
    ├── mvnw
    ├── mvnw.cmd
    └── src/
        ├── main/
        │   ├── java/com/api/tanish/cipherterminal/
        │   │   ├── CipherTerminalApplication.java
        │   │   ├── EncryptionController.java
        │   │   ├── EncryptionService.java
        │   │   └── EncryptionResponse.java
        │   └── resources/
        │       └── application.properties
        └── test/
```

### Architecture

- **EncryptionController** — maps incoming HTTP requests to the encrypt and decrypt operations.
- **EncryptionService** — contains the Caesar cipher transformation and shift logic.
- **EncryptionResponse** — defines the JSON response containing the original text, transformed text, and operation.
- **CipherTerminalApplication** — Spring Boot application entry point.

The controller receives `EncryptionService` through constructor injection.

## Getting Started

### Prerequisites

- JDK 21 or later
- Git
- An IDE such as IntelliJ IDEA, Eclipse, or VS Code (optional)

### 1. Clone the repository

```bash
git clone https://github.com/JainSahab45/Cipher-Terminal-Project.git
cd Cipher-Terminal-Project/Cipher\ Terminal
```

### 2. Run the application

On macOS/Linux:

```bash
./mvnw spring-boot:run
```

On Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

The application uses Spring Boot's default port **8080**, unless changed in the application configuration.

### 3. Build and test

```bash
./mvnw clean test
./mvnw package
```

On Windows, use `.\mvnw.cmd` instead of `./mvnw`.

## API Documentation

Base URL:

```text
http://localhost:8080/api
```

### 1. Encrypt text

**Endpoint:** `GET /api/encrypt`

**Query parameter:** `message` — the text to encrypt.

Example request:

```http
GET http://localhost:8080/api/encrypt?message=Hello%20World
```

Example response:

```json
{
  "originalText": "Hello World",
  "transformedText": "Mjqqt Btwqi",
  "operation": "encryption"
}
```

### 2. Decrypt text

**Endpoint:** `GET /api/decrypt`

**Query parameter:** `message` — the Caesar-cipher text to decrypt.

Example request:

```http
GET http://localhost:8080/api/decrypt?message=Mjqqt%20Btwqi
```

Example response:

```json
{
  "originalText": "Mjqqt Btwqi",
  "transformedText": "Hello World",
  "operation": "decryption"
}
```

### Endpoint Summary

| Method | Endpoint | Parameter | Description |
|---|---|---|---|
| GET | `/api/encrypt` | `message` | Encrypt text using a shift of 5 |
| GET | `/api/decrypt` | `message` | Decrypt text using the inverse shift |

You can try these endpoints in a browser, Postman, or with cURL:

```bash
curl --get "http://localhost:8080/api/encrypt" --data-urlencode "message=Hello World"

curl --get "http://localhost:8080/api/decrypt" --data-urlencode "message=Mjqqt Btwqi"
```

## Learning Outcomes

This project provides practical experience with:

- Creating REST endpoints using Spring WebMVC.
- Applying `@RestController`, `@RequestMapping`, `@GetMapping`, and `@RequestParam`.
- Implementing constructor-based dependency injection.
- Separating controller and service responsibilities.
- Returning Java objects as JSON responses.
- Implementing character-level transformation logic using Java.

## Future Improvements

Potential extensions for the project:

- Allow clients to provide a custom shift value.
- Support additional classical ciphers such as Vigenère.
- Add input validation and structured error responses.
- Add unit tests for encryption, decryption, and edge cases.
- Provide POST endpoints for larger text payloads.

## Author

**Tanish Jain**

- GitHub: [@JainSahab45](https://github.com/JainSahab45)
- Repository: [Cipher-Terminal-Project](https://github.com/JainSahab45/Cipher-Terminal-Project)

---

If you find this project useful, feel free to explore the code and suggest improvements.
