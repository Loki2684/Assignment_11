pipeline {
    agent any

    tools {
        maven 'Maven_3.9.6'    // Or your Maven tool name in Jenkins
        jdk 'JDK17'            // Or your configured JDK
    }

    environment {
        SONAR_SCANNER_HOME = tool 'SQ_Scanner'   // Sonar scanner name in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Loki2684/Assignment_11.git'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarCloud') {
                    sh "${env.SONAR_SCANNER_HOME}/bin/sonar-scanner"
                }
            }
        }

        stage('Build Package') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
