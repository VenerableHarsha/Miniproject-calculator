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

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'Dockerhub cred',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
                    sh 'docker push venerableharsha/calculator-app:latest'
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i inventory.ini deploy.yml'
            }
        }

    }
}