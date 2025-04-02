# AI Chat Summarizer

This project is a chat-based AI summarization tool built using Spring Boot, React, PostgreSQL, and Ollama AI. Users can send text or upload PDF files, and the AI will generate summaries while maintaining chat sessions.

## Features

- Real-time AI-powered text summarization

- PDF text extraction and summarization

- Chat session persistence

- REST API support

- PostgreSQL database integration

## Technologies Used

- Backend: Spring Boot, Ollama AI, PostgreSQL

- Frontend: React, Axios

- Database: PostgreSQL

## Installation & Setup

### Backend (Spring Boot)

- Clone the repository:
```
git clone https://github.com/your-repo.git
cd backend
```
- Install dependencies:
```
mvn clean install
```
- Configure database in application.properties:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/yourdb
spring.datasource.username=youruser
spring.datasource.password=yourpassword
```
- Run the Spring Boot application:
```
mvn spring-boot:run
```
### Frontend (React)

- Navigate to the frontend folder:
```
cd frontend
```
- Install dependencies:
```
npm install
```
- Start the React app:
```
npm run dev
```
### API Endpoints

- REST API

- Chat API
  
- POST ```/api/chat```
### Request Body:
```json
{
  "message": "Your text here"
}
```
### Response:
```json
{
  "response": "Summarized text"
}
```
- POST ```/api/upload```

- Uploads a PDF file and extracts text for summarization.
