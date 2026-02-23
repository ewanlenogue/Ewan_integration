pipeline {
    agent any

    tools {
        maven 'maven'
        nodejs 'nodejs'
    }

    stages {

        stage('Backend - Tests') {
            steps {
                dir('Backend') {
                    sh 'mvn clean test'
                }
            }
        }


        
    }
}

