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
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Building Docker image...'
                sh 'docker build -t student-app .'
            }
        }

        stage('Run Container') {
            steps {
                echo 'Running Docker container...'
                sh 'docker stop student-app-container || true'
                sh 'docker rm student-app-container || true'
                sh 'docker run -d --name student-app-container -p 8080:8080 student-app'
            }
        }
    }
}

