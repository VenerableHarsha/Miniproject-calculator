pipeline {
    agent any

    stages {


        stage('Build') {
            steps {
                dir('Calculator') {
                                    sh 'mvn clean compile'
                                }

            }
        }

        stage('Run Tests') {
            steps {
            dir("Calculator"){sh 'mvn test'}

            }
        }

        stage('Package Application') {
            steps {
            dir("Calculator"){sh 'mvn package'}

            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t calculator-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d --name calculator-container calculator-app || true'
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i inventory.ini deploy.yml'
            }
        }

    }
}