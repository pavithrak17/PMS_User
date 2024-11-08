
# Placement Management System

<p align="center">
    <img src="https://tse4.mm.bing.net/th?id=OIP.FdBNRKqM8j3sFgS6srVoAAHaIT&pid=Api&P=0&h=180" alt="Project Logo" width="200"/>
</p>

## Introduction
The **Placement Management System** is designed to streamline the placement process for educational institutions. It provides a robust backend solution to manage user profiles, job postings, and applications efficiently. Built using Java and Spring Boot, this system ensures secure and reliable interactions between users and the platform, facilitating a smooth placement experience for both students and recruiters.

## Table of Contents
- [About](#about)
- [Technologies Used](#technologies-used)
- [Frontend Technologies](#frontend-technologies)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [User Module](#user-module)
- [Frontend Demo](#frontend-demo)
- [License](#license)
- [Contact](#contact)

## About
---
The Placement Management System is built using Java and Spring Boot for the backend and React.js for the frontend. The backend handles server-side logic, database interactions, and RESTful API endpoints, while the frontend provides a user-friendly interface for interaction.

---

## Technologies Used
---
- **Java**: Programming language used for backend development.  
- **Spring Boot**: Framework for building the backend application.  
- **Spring Data JPA**: For database interaction and ORM.  
- **MySQL**: Relational database for data storage.  
- **Maven**: Dependency management and build tool.  
---

## Frontend Technologies
---
- **React.js**: JavaScript library for building user interfaces.
- **Axios**: For making HTTP requests from the frontend.
- **CSS**: Styling the frontend to ensure a responsive and user-friendly experience.

---

## Installation

To set up both the backend and frontend on your local machine, follow these steps:

### Backend Installation:
1. **Clone the backend repository:**
   ```bash
   git clone https://github.com/pavithrak17/placement-management-system-backend.git
   ```
2. **Navigate to the backend project directory:**
   ```bash
   cd placement-management-system-backend
   ```
3. **Configure the database** (MySQL):
   - Create a new MySQL database for the application.
   - Update the `application.properties` file with your database connection details:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```
4. **Build and run the backend application:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### Frontend Installation:
1. **Clone the frontend repository:**
   ```bash
   git clone https://github.com/pavithrak17/placement-management-system-frontend.git
   ```
2. **Navigate to the frontend project directory:**
   ```bash
   cd placement-management-system-frontend
   ```
3. **Install dependencies:**
   ```bash
   npm install
   ```
4. **Run the frontend application:**
   ```bash
   npm start
   ```

This will start the frontend application, which will be available on `http://localhost:3000`.

---

## Usage

Once both the backend and frontend applications are running, you can interact with the API using the frontend interface at `http://localhost:3000`. The backend API will be available at `http://localhost:8080`.

## API Endpoints

Here are some key API endpoints:

| Method | Endpoint                     | Description                     |
|--------|------------------------------|---------------------------------|
| GET    | `/api/users`                 | Retrieve all users              |
| GET    | `/api/users/{id}`            | Retrieve a user by ID           |
| POST   | `/api/users`                 | Create a new user               |
| PUT    | `/api/users/{id}`            | Update a user by ID             |
| DELETE | `/api/users/{id}`            | Delete a user by ID             |

## User Module
---
The **User Module** is a key component of the Placement Management System, responsible for managing user-related functionalities. This module allows for user registration, authentication, and management of user profiles.

### Key Features:
- **User Registration**: New users can create accounts by providing necessary details, which are securely stored in the database.
- **User Authentication**: Registered users can log in using their credentials, enabling access to the system.
- **User Management**: Administrators can view, update, and delete user profiles as needed, ensuring effective management of user data.

---

## Frontend Demo
### Demo Video
Watch the demo of my project below:

[![Project Demo](https://via.placeholder.com/360)](https://drive.google.com/file/d/1eoyyIvnbbS-qp0HO4rGxoS0tpT_n6VBo/view?usp=drive_link)

Or alternatively, you can [click here to watch the video on Google Drive](https://drive.google.com/file/d/1eoyyIvnbbS-qp0HO4rGxoS0tpT_n6VBo/view?usp=drive_link).

---

# Screenshots
![image](https://github.com/user-attachments/assets/74d8362d-86df-447c-a4f3-bd19433b0ce8)
![image](https://github.com/user-attachments/assets/8a85b0b7-e977-45db-bc31-8cf90967ba8e)
![image](https://github.com/user-attachments/assets/d78727cd-0435-4956-8282-c747275dc7da)
![image](https://github.com/user-attachments/assets/1f06c1b6-26cf-4b92-b8f3-8621317ac20a)
![image](https://github.com/user-attachments/assets/f9ff682d-2ccd-48ac-9123-fe0ff5c2ed21)
![image](https://github.com/user-attachments/assets/fe523396-0035-43d9-8a1d-8b3fe0b4ac8c)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For questions or feedback, please reach out to:<br>
**Name:** Pavithra K<br>
**GitHub:** [pavithrak17](https://github.com/pavithrak17)

---

<p align="center">
    Thank you for checking out the Placement Management System! 🎉
</p>
```
