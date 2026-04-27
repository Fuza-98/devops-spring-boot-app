pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                echo 'Cloning repository from GitHub...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building Java application using Maven...'
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Building Docker image...'
                bat 'docker build -t student-app .'
            }
        }

        stage('Run Container') {
            steps {
                echo 'Running Docker container...'
                bat 'docker stop student-app-container || true'
                bat 'docker rm student-app-container || true'
                bat 'docker run -d --name student-app-container -p 8080:8080 student-app'
            }
        }
    }
}

