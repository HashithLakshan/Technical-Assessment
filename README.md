# **ToDo Application**

A simple and effective to-do list application built to run seamlessly in a containerized environment using Docker.

## **🚀 Getting Started**

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### **Prerequisites**

Before you begin, ensure you have the following installed and configured on your system:

* **Docker Desktop:** Download and install it from the [official Docker website](https://www.docker.com/products/docker-desktop/).

**Note:** If you have a local MySQL service running on your machine (e.g., via XAMPP, WAMP, or a standalone installation), please make sure to **stop it** before proceeding. This is necessary to prevent port conflicts with the application's database container.

### **Installation and Setup**

Follow these steps to get your development environment running:

1. Clone the Repository  
   Open your terminal or command prompt and clone the project to your local machine:  
   git clone \<your-repository-url\>

   *Replace \<your-repository-url\> with the actual URL of your Git repository.*  
2. Navigate to the Project Directory  
   Change into the newly cloned project folder:  
   cd \<project-folder-name\>

3. Launch the Application  
   From inside the project's root directory, run the following command in your terminal. This will build the necessary Docker images and start the application containers (frontend, backend, and database).  
   docker-compose up \--build

4. Wait for Liftoff\! ⏳  
   The initial build process may take a few minutes. Wait patiently until the terminal logs indicate that the database, backend, and frontend services are up and running successfully.

## **💻 Accessing the Services**

Once all the containers are running, you can access the different parts of the application.

### **Application Frontend**

Open your favorite web browser and navigate to:

[**http://localhost:4200**](https://www.google.com/search?q=http://localhost:4200)

You should now see the ToDo Application's user interface.

### **Database Admin**

To view and manage the application's database, navigate to:

[**http://localhost:8082**](https://www.google.com/search?q=http://localhost:8082)

Use the following credentials to log in:

* **Username:** root  
* **Password:** Gr3atS3cur\!ty\_2025

## **🛑 Stopping the Application**

To stop all the running application containers, return to the terminal where the application is running and press Ctrl \+ C.