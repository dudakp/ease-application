pipeline {
    agent {
        docker {
            image 'maven:3.8.4-openjdk-11-slim'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn package'
            }
        }
  stage('Docker build and run') {
            steps {
                sh "docker stop ease-application"
                sh "docker rm ease-application"
                sh "docker build -t ease/application ."
                sh "docker run -d -p 8080:8080 --env-file $JENKINS_HOME/.envvars/.env-be --name ease-application ease/application"
                echo "Dockerizing app complete!"
            }
        }
   }
}
