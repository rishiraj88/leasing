CREATE DATABASE IF NOT EXISTS leasedb;
use leasedb;

DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS vehicles;
DROP TABLE IF EXISTS leasecontracts;

CREATE TABLE customers (
id VARCHAR(40) PRIMARY KEY,
name VARCHAR(17) NOT NULL,
birth_date DATE NOT NULL
);

CREATE TABLE vehicles (
id VARCHAR(40) PRIMARY KEY,
brand VARCHAR(12) NOT NULL,
model VARCHAR(12) NOT NULL,
make_year VARCHAR(4),
vin VARCHAR(12) NOT NULL,
price DECIMAL(8,2),
INDEX(vin)
);

CREATE TABLE leasecontracts (
id VARCHAR(40) PRIMARY KEY,
lcnum INT(8) NOT NULL,
monthly_rate DECIMAL(6,2) NOT NULL,
vin VARCHAR(12),
customer_name VARCHAR(17),
INDEX(vin),
FOREIGN KEY(vin) REFERENCES vehicles(vin),
INDEX(customer_name),
FOREIGN KEY(customer_name) REFERENCES customers(customer_name)
);
-- TODO to alter leasecontracts at later stages of development