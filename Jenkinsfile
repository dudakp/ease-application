pipeline {
    agent any
    tools {
        maven "maven"
    }
    stages {
        stage('Build') {
            steps {
                sh 'cd ease && mvn spring-boot:build-image'
            }
        }
        stage('Run docker image') {
            steps {
                load "$JENKINS_HOME/.envvars/.env-be"
                sh 'docker run -it -p 8080:8080 OKTA_ISSUER=${env.OKTA_ISSUER}; OKTA_CLIENT_ID=${env.OKTA_CLIENT_ID}; OKTA_CLIENT_SECRET=${env.OKTA_CLIENT_SECRET}; POSTGRES_URL=${emv.POSTGRES_URL}; POSTGRES_USER=${env.POSTGRES_USER}; POSTGRES_PWD=${env.POSTGRES_PWD}; POSTGRES_DB=${env.POSTGRES_DB}; NEO4J_URL=${env.NEO4J_URL}; NEO4J_USERNAME=${env.NEO4J_USERNAME}; NEO4J_PWD=${env.NEO4J_PWD} ease:0.0.1-SNAPSHOT'
            }
        }
    }
}
