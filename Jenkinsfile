pipeline {
    agent any

    tools {
        maven 'maven'      // Maven tool configured in Jenkins
        jdk 'JDK'          // JDK tool (name must match Jenkins config)
    }

    environment {
        SONAR_SCANNER_HOME = tool 'SQ_Scanner'   // SonarScanner tool
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
            junit '**/target/surefire-reports/*.xml' // Collect JUnit results
        }
    }
}
