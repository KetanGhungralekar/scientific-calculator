pipeline {
    agent any

    tools {
        maven 'Maven'   // Make sure Maven is configured in Jenkins (Global Tool Config)
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-credentials',
                    url: 'https://github.com/KetanGhungralekar/scientific-calculator.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t ketan803/scientific-calculator:latest .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                        docker push ketan803/scientific-calculator:latest
                    '''
                }
            }
        }
        stage('Deploy with Ansible') {
            steps {
                withEnv(["PATH+LOCAL=/var/lib/jenkins/.local/bin"]) {
                    sh '''
                        ansible-playbook -i hosts.ini deploy_calculator.yml
                    '''
                }
            }
        }
    }
}
