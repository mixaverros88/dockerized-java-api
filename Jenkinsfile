pipeline {
    agent any
    stages {
        stage('Git'){
            steps{
                echo "Clone Stage";
                git 'https://github.com/mixaverros88/dockerized-java-api'
            }
        }

        stage('Mvn'){
            steps{
                echo "Compile Stage";
                bat 'build.bat'
            }
        }

        stage('Deploy'){
            steps{
                echo "Deploy in Tomcat";
                deploy adapters: [tomcat9(credentialsId: '38635434-9f3c-40e9-b2fb-acf2d792224c', path: '', url: 'http://localhost:8080/')], contextPath: 'demorest', war: '**/*.war'
            }
        }

    }
    post{
      always {
        junit '**/*.xml'
      }
      failure {
        mail bcc: '', body: '', cc: '', from: '', replyTo: '', subject: 'The Pipeline fail', to: 'mixalisverros@hotmail.gr'
      }
    }
}
