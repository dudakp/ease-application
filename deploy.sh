#!/bin/bash

mvn clean package
docker stop ease-application
docker rm ease-application
docker build -t ease/application .
docker run -d -p 8080:8080 --env-file .env --name ease-application ease/application
