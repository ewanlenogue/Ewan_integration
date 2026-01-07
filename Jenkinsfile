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


        
    }
}

