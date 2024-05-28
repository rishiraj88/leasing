CREATE DATABASE IF NOT EXISTS leasedb;
use leasedb;

DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS vehicle;
DROP TABLE IF EXISTS lcontract;

CREATE TABLE customer (
customer_id VARCHAR(8) PRIMARY KEY,
name VARCHAR(17) NOT NULL,
bdate DATE NOT NULL
);

CREATE TABLE vehicle (
vehicle_id VARCHAR(8) PRIMARY KEY,
brand VARCHAR(12) NOT NULL,
model VARCHAR(12) NOT NULL,
myear VARCHAR(12) NOT NULL,
vin VARCHAR(12) NOT NULL,
price DECIMAL(8,2) NOT NULL,
INDEX(vin)
);

CREATE TABLE lcontract (
lcontract_id VARCHAR(10) PRIMARY KEY,
lcnum INT(8) NOT NULL,
mrate DECIMAL(6,2) NOT NULL,
vehicle_id VARCHAR(12),
customer_id VARCHAR(8),
INDEX(vehicle_id),
FOREIGN KEY(vehicle_id) REFERENCES vehicle(vin),
INDEX(customer_id),
FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);
