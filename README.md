Tech Venturas Network Management System

Overview: This project provides a RESTful API solution to manage gateways and attached peripheral devices for Tech Venturas' network management system. The solution allows users to perform CRUD operations on gateways and peripheral devices, along with validation of input fields and adherence to specified constraints.

Technologies Used
- Programming Language: Java
- Framework: Spring Boot
- Database: MySQL
- Testing Framework: Postman

Requirements
- Java JDK 11 or higher
- Apache Maven
- MySQL database

Setup Instructions
1. Clone the Repository:
    ```bash
    git clone https://github.com/your-username/tech-venturas-api.git
    ```

2. Database Configuration:
    - Install MySQL and create a new database named `tech_venturas_db`.
    - Update the `application.properties` file with your database credentials:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/tech_venturas_db
        spring.datasource.username=your_username
        spring.datasource.password=your_password        
      ```
3. Build and Run the Application:
    ```bash
    cd tech-venturas-api
    mvn clean install
    java -jar target/tech-venturas-api.jar
    ```

4. API Documentation:
    - Access the API documentation at `http://localhost:8080/swagger-ui.html` after starting the application.

API Endpoints
- Gateways:
    - `GET /api/gateways`: Get all gateways
    - `GET /api/gateways/{serialNumber}`: Get gateway by serial number
    - `POST /api/gateways`: Create a new gateway
    - `PUT /api/gateways/{serialNumber}`: Update an existing gateway
    - `DELETE /api/gateways/{serialNumber}`: Delete a gateway

- Peripheral Devices:
    - `GET /api/peripheral-devices`: Get all peripheral devices
    - `GET /api/peripheral-devices/{uid}`: Get peripheral device by UID
    - `POST /api/peripheral-devices`: Create a new peripheral device
    - `PUT /api/peripheral-devices/{uid}`: Update an existing peripheral device
    - `DELETE /api/peripheral-devices/{uid}`: Delete a peripheral device

 Validation
- Validation of input fields, including IPv4 address validation, is implemented for gateways and peripheral devices.
- Constraints such as the maximum number of peripheral devices allowed for a gateway (10) are enforced.

Testing
- Unit tests are provided for each endpoint using Postman
  
Assumptions
1. Peripheral devices can only be associated with one gateway at a time.
2. One gateway can have only 10 peripheral devices.
3. When doing Patch mapping in peripheral devices update only vendor and in gateway update only the name.
   
ER Diagram
 ![image](https://github.com/RavinduLK/NMS-TechVenturas/assets/94894276/769013c7-03de-4d2d-a52f-95b83d44d1f6)

