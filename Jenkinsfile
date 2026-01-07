pipeline {
    agent any

    tools {
        maven 'Maven'
        nodejs 'Node'
    }

    stages {

        stage('Backend - Tests') {
            steps {
                dir('Backend/tp_automatisation_tests') {
                    sh 'mvn clean test'
                }
            }
        }

        stage('Frontend - Tests') {
            steps {
                dir('Frontend/tp_automatisation_tests') {
                    sh 'npm install'
                    sh 'npm test -- --watch=false'
                }
            }
        }

        stage('Selenium Tests') {
            steps {
                dir('selenium-tests') {
                    sh 'mvn test'
                }
            }
        }
    }
}

