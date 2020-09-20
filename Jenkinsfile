pipeline {
    agent any
    environment {
      PROJECT_NAME = "Java Rest API"
    }
    stages {
        stage('Git'){
            steps{
                echo "Clone ${PROJECT_NAME} Stage";
                git 'https://github.com/mixaverros88/dockerized-java-api'
            }
        }

        stage('Mvn'){
            steps{
                echo "Compile ${PROJECT_NAME} Stage";
                bat 'build.bat'
            }
        }

        stage('Deploy'){
            steps{
                echo "Deploy ${PROJECT_NAME} in Tomcat";
                deploy adapters: [tomcat9(credentialsId: '38635434-9f3c-40e9-b2fb-acf2d792224c', path: '', url: 'http://localhost:8080/')], contextPath: 'demorest', war: '**/*.war'
            }
        }

    }
    post{
      always {
        junit '**/*.xml'
      }
      success{
         mail bcc: '', body: '', cc: '', from: '', replyTo: '', subject: 'The Pipeline for ${PROJECT_NAME} success', to: 'mixalisverros@hotmail.gr'
      }
      failure {
        mail bcc: '', body: '', cc: '', from: '', replyTo: '', subject: 'The Pipeline for ${PROJECT_NAME} fail', to: 'mixalisverros@hotmail.gr'
      }
    }
}
