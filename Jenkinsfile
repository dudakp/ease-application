pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './ease/.mvnw spring-boot:build-image'
            }
        }
        stage('Run docker image') {
            steps {
                load "$JENKINS_HOME/.envvars/.env-be"
                sh 'docker run -it -p 8080:8080 --env-file=.env ease:0.0.1-SNAPSHOT'
            }
        }
    }
}
