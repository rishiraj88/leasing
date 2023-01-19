# Leasing Application

to manage leasing contracts for customers and vehicles

## Preconditions to Run the Application

- Java 11
- Spring Boot ^2.5
- MySQL or MariaDB (out of Docker)
- Docker
- Gradle
- Flyway database migration for initial schema
- OpenAPI Spec. to generate server/client (optional)
- Angular ^13

## How to Start the Application

- Pull mysql from docker hub (mysql - Official Image | Docker Hub):
`docker pull mysql:8.0.31`

- (Optional) To connect to mysql server and check database, tables and data:
`winpty docker run -it --network host --rm mysql mysql -hdocker-desktop -uroot -ppassword`
mysql> `show databases;`
mysql> `use leasedb;`
mysql> `show tables;`
mysql> `select * from customer;`

- To test the project setup with MySQL database, with Postman (independent software application) or ThunderClient (an extension of VS Code) make the following POST request (to add new customers):
`http://localhost:8080/customer/?fname=Sddeto&lname=Sddhukla&bdate=05-05-2019`
`http://localhost:8080/customer/?fname=Rajesh&lname=Ji&bdate=01.05.2020`

- To test the API of updating the customers, make this PUT request with Postman or ThunderClient:
`http://localhost:8080/customer/?fname=Ri&lname=Jajesh&bdate=01.03.2020`


## Reason of Chosen Solution

