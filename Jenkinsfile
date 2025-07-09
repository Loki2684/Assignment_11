pipeline {
    agent any
 
    environment {
        SONARQUBE_SCANNER_HOME = tool 'SonarQubeScanner'
    }
 
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Loki2684/Assignment_11.git', branch: 'master'
            }
        }
 
        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test -Dtest=com.example.SeleniumTest'
            }
        }
 
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonarQubeServer') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
 
        stage('Build Package') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
 
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }
    }
}
