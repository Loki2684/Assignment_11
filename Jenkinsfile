pipeline {
    agent any

    tools {
        maven 'maven'      // default Maven tool (configured in Jenkins)
        jdk 'JDK'          // default JDK tool (configured in Jenkins)
    }

    environment {
        SONAR_SCANNER_HOME = tool 'SQ_Scanner'   // use your actual scanner name here
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
