📘 AI Teacher & App Generator Platform

A Spring Boot–based AI-powered platform that provides:

🎓 Subject-wise AI Teacher (Maths, Physics, Chemistry)

🧠 Session-based memory with notes & PDF generation

👤 Student registration & login

⚙️ AI App Generator

📄 Swagger (OpenAPI) documentation

🚀 Tech Stack

Java 17+

Spring Boot 3

Spring Web

Spring Data JPA

PostgreSQL

Spring AI (ChatClient)

OpenPDF (PDF generation)

springdoc-openapi (Swagger UI)

🌐 Application URLs
Purpose	URL
Application	http://localhost:8080
Swagger UI	http://localhost:8080/swagger-ui/index.html
OpenAPI JSON	http://localhost:8080/v3/api-docs
📦 Modules Overview
1️⃣ Student Management

Register students

Login students

List all students

Delete student

2️⃣ AI Teacher (Core Feature)

Subject-wise teacher (Maths / Physics / Chemistry)

Session-based memory

Context-aware answers

Notes creation per session

3️⃣ Learning Sessions

One active session per student per subject

Session ends manually

Notes + PDF generated on session end

4️⃣ AI App Generator

Generate apps based on user input

Track generation status

🔐 API Endpoints (From Swagger)
🎓 Teaching Controller
Ask Question (AI Teacher)
POST /api/teacher/ask


Request Body

{
"studentId": 1,
"subject": "MATHS",
"grade": "10",
"topic": "Algebra",
"question": "What is a quadratic equation?"
}


Response

{
"subject": "MATHS",
"answer": "A quadratic equation is of the form ax² + bx + c = 0..."
}

👤 Student Controller
Register Student
POST /api/students/register

{
"name": "Rahul Sharma",
"email": "rahul@gmail.com",
"password": "123456",
"grade": "10"
}

Login Student
POST /api/students/login

{
"email": "rahul@gmail.com",
"password": "123456"
}

Get All Students
GET /api/students

Delete Student
DELETE /api/students/{id}

🧠 Session Controller
End Learning Session
POST /api/session/end/{sessionId}


What happens internally:

Session marked inactive

Notes created from chat history

PDF generated and saved to filesystem

⚙️ App Generation Controller
Generate App
POST /api/app/generate

{
"appName": "MyApp",
"appType": "WEB",
"techStack": "SPRING_BOOT",
"features": ["CRUD", "AUTH"]
}

Get App Generation Status
GET /api/app/status/{projectId}

🧠 Session & Memory Design

Each student + subject has one active session

Memory persists in database (chat_message table)

AI context limited to last 10 messages

Full history used for notes & PDF

📄 Notes & PDF Generation

Notes are generated when session ends

PDF stored in filesystem

Default PDF Location
<project-root>/notes/session_<sessionId>.pdf

🗄️ Database Tables

students

learning_session

chat_message

notes

project_entity

⚙️ Configuration
application.properties
server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5432/aiteacher
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

notes.storage.path=notes

🧪 API Testing

Use Swagger UI for testing

Or use Postman

Follow flow:

Register student

Login student

Ask subject-wise questions

End session

Download PDF

🚧 Future Enhancements

JWT Authentication

Role-based access (Student / Admin)

AI-based notes summarization

Resume previous sessions

Cloud storage for PDFs (S3)

Frontend (React / Angular)

✅ Status

✔ Core APIs implemented
✔ Swagger integrated
✔ Session memory working
✔ PDF generation working