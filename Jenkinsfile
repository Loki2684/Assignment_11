pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'JDK'
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-pat', url: 'https://github.com/Loki2684/Assignment_11.git'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn package'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarCloud') {
                sh "${tool 'SQ_Scanner'}/bin/sonar-scanner"
                }
             }
          }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
