pipeline {
    agent any

    tools {
        maven 'maven'      // Must match Maven tool name in Jenkins
        jdk 'JDK'          // Must match JDK tool name in Jenkins
    }

    environment {
        SONAR_SCANNER_HOME = tool 'SQ_Scanner'   // SonarScanner tool name in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Loki2684/Assignment_11.git', credentialsId: 'github-pat'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarCloud') {
                    sh "${SONAR_SCANNER_HOME}/bin/sonar-scanner"
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
