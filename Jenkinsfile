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
                git url: 'https://github.com/Chandrakanth-Git-Hub/Test.git', branch: 'main'
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
                    sh 'cp target/hello-world.war /opt/tomcat/webapps/'
                }
            }
        }
    }

    post {
    success {
        emailext(
            subject: "SUCCESS: ${currentBuild.fullDisplayName}",
            body: "Build SUCCESSFUL: ${env.BUILD_URL}",
            to: "chandubhavi123@gmail.com"
        )
    }
    failure {
        emailext(
            subject: "FAILURE: ${currentBuild.fullDisplayName}",
            body: "Build FAILED: ${env.BUILD_URL}",
            to: "chandubhavi123@gmail.com"
            )
        }
    }
}

