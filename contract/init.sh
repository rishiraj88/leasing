#!/bin/bash
#docker run --name db --network some-network -e MYSQL_DATABASE=leasedb -e MYSQL_ROOT_PASSWORD=leasedb -v db_contract:/var/lib/mysql -d mysql:8.0.31
docker run --name localhost --cpus=.5 --memory=160m -e MYSQL_DATABASE=leasedb -e MYSQL_ROOT_PASSWORD=leasedb -v db_contract:/var/lib/mysql -d mysql:8.0.31