pipeline {
    agent any

    tools {
        maven 'Maven'
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
                sh 'docker build -t ketan803/scientific-calculator:1.0 .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                        docker push ketan803/scientific-calculator:1.0
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

    post {
        success {
            emailext (
                subject: "✅ SUCCESS: Build #${env.BUILD_NUMBER} - ${env.JOB_NAME}",
                body: """
                <h3>Build Successful 🎉</h3>
                <p>Job: ${env.JOB_NAME}</p>
                <p>Build Number: ${env.BUILD_NUMBER}</p>
                <p>Check console output: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                """,
                to: "kghungralekar1234@gmail.com",
                attachLog: true,
                mimeType: 'text/html'
            )
        }
        failure {
            emailext (
                subject: "❌ FAILED: Build #${env.BUILD_NUMBER} - ${env.JOB_NAME}",
                body: """
                <h3>Build Failed ❗</h3>
                <p>Job: ${env.JOB_NAME}</p>
                <p>Build Number: ${env.BUILD_NUMBER}</p>
                <p>Check console output: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                """,
                to: "kghungralekar1234@gmail.com",
                attachLog: true,
                mimeType: 'text/html'
            )
        }
    }
}
