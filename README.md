# **ToDo Application**

This is a simple ToDo application that helps you manage your tasks. Follow the instructions below to get it up and running on your local machine using Docker.

## **Getting Started**

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### **Prerequisites**

You'll need the following software installed on your computer:

* **Docker Desktop**: Ensure Docker Desktop is installed and properly configured on your system. You can download it from the [official Docker website](https://www.docker.com/products/docker-desktop/).

### **Installation**

Follow these steps to set up the ToDo application:

1. **Clone the Repository**  
   First, clone the project from its GitHub repository to your local machine:  
   git clone \[your-repository-url\] 

   *Replace \[your-repository-url\] with the actual URL of your project's GitHub repository.*  
2. **Stop Existing MySQL Service (If Applicable)**  
   If you have a MySQL service already running on your computer, please stop it to avoid port conflicts with the Dockerized database.  
3. **Navigate to the Project Folder**  
   Open your terminal or command prompt and navigate into the cloned project directory:  
   cd todoApplication 

   *(Assuming todoApplication is the name of your cloned folder)*  
4. **Database Access (Optional)**  
   If you wish to view the database directly using a database management tool (like MySQL Workbench or XAMPP), you can find the database username and password in the following file:  
   backend/src/main/resources/application.properties  
5. **Run the Application with Docker Compose**  
   From within the project's root directory in your terminal, execute the following command:  
   docker-compose up \--build

   This command will build the necessary Docker images and start all the services (database, backend, and frontend).  
6. **Wait for Services to Start**  
   Allow some time for all the services (database, frontend, and backend) to fully start up. You'll see logs indicating their progress in your terminal.  
7. **Access the Application**  
   Once all services are up and running, open your web browser and navigate to:  
   http://localhost:4200

   You should now see the ToDo application in your browser\!