pipeline {
    agent any

    environment {
        MAVEN_HOME = "/opt/apache-maven"
        PATH = "$MAVEN_HOME/bin:$PATH"
        DEPLOY_PATH = "/opt/tomcat/webapps"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Chandrakanth-Git-Hub/git.git'
            }
        }

        stage('Build') {
            steps {
                dir('hello-world') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Test') {
            steps {
                dir('hello-world') {
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                dir('hello-world') {
                    echo 'Deploying WAR file to Tomcat...'
                    sh "cp target/hello-world.war $DEPLOY_PATH/"
                }
            }
        }
    }

    post {
        success {
            emailext subject: "✅ Build Successful: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: "Good news! Build #${env.BUILD_NUMBER} succeeded.",
                     to: "chandubhavi123@gmail.com"
        }
        failure {
            emailext subject: "❌ Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: "Build #${env.BUILD_NUMBER} failed. Please check Jenkins logs.",
                     to: "chandubhavi123@gmail.com"
        }
    }
}

