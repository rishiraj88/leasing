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

## Reason of Chosen Solution

