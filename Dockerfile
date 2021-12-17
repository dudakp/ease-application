FROM openjdk:11-slim-buster
EXPOSE 8080
ARG JAR_FILE=ease/target/ease-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} ease-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","ease-0.0.1-SNAPSHOT.jar"]
