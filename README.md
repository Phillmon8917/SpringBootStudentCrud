
# Student CRUD API with Spring Boot

This project is a simple Student CRUD (Create, Read, Update, Delete) API built using Spring Boot. The API allows users to register students, check if their email is already registered, and perform basic CRUD operations.

## Features

- **Student Registration**: Allows users to register a student with a name, email, and other details. If the email is already registered, an exception is thrown.
- **Return String**: The API returns appropriate strings based on user actions.
- **Return List**: The API returns a list of registered students.
- **Exception Handling**: If a user tries to register a student with an already registered email, an exception is thrown.
- **CRUD Operations**: Implemented all CRUD operations for students, including creating, reading, updating, and deleting students.

## Database Configuration

- **MySQL**: The application is connected to a MySQL database.
- **Create-Drop Approach**: The database uses a create-drop approach, meaning the database schema is created when the application starts and dropped when the application stops.
- **Pre-population of Data**: Two students are pre-configured to be registered when the application starts.

## Endpoints

### 1. Register Student
- **Method**: POST
- **Request Body**: JSON containing student information (name, email, etc.)
- **Response**: A string message indicating the success or failure of the registration.
- **Exception**: If the email is already registered, an exception is thrown.

### 2. Get All Students
- **Method**: GET
- **Response**: A list of all registered students.

### 3. Get Student by ID
- **Method**: GET
- **Response**: The student details for the given ID.

### 4. Update Student
- **Method**: PUT
- **Request Body**: JSON containing the updated student information.
- **Response**: A string message indicating the success of the update.

### 5. Delete Student
- **Method**: DELETE
- **Response**: A string message indicating the success of the deletion.

## Exception Handling

The application includes basic exception handling to ensure that the user is notified if there is an issue, such as attempting to register a student with an already registered email.

