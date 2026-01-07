pipeline {
    agent any

    tools {
        maven 'Maven'
        nodejs 'Node'
    }

    environment {
        JAVA_HOME = tool 'JDK21'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Backend - Build & Tests') {
            steps {
                dir('Backend/tp_automatisation_tests') {
                    sh 'mvn clean test'
                }
            }
            post {
                always {
                    junit 'Backend/tp_automatisation_tests/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Frontend - Build') {
            steps {
                dir('Frontend/tp_automatisation_tests') {
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }

        stage('Selenium UI Tests') {
            when {
                branch 'main'
            }
            steps {
                dir('selenium-tests') {
                    sh 'mvn test'
                }
            }
            post {
                always {
                    junit 'selenium-tests/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Cucumber BDD Tests') {
            when {
                branch 'main'
            }
            steps {
                dir('cucumber-gherkin-selenium-tests') {
                    sh 'mvn test'
                }
            }
            post {
                always {
                    junit 'cucumber-gherkin-selenium-tests/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline SUCCESS'
        }
        failure {
            echo 'Pipeline FAILED'
        }
    }
}

