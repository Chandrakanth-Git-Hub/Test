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
                git url: 'https://github.com/Chandrakanth-Git-Hub/git.git', branch: 'main'
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
            echo 'Build and deploy succeeded! Sending email...'
            emailext(
                to: 'chandubhavi123@gmail.com',
                subject: "Jenkins: SUCCESS - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>Build SUCCESSFUL</p>
                         <p>Job: ${env.JOB_NAME}</p>
                         <p>Build Number: ${env.BUILD_NUMBER}</p>
                         <p>Check console output at ${env.BUILD_URL}</p>""",
                mimeType: 'text/html'
            )
        }
        failure {
            echo 'Build failed! Sending email...'
            emailext(
                to: 'chandubhavi123@gmail.com',
                subject: "Jenkins: FAILURE - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>Build FAILED</p>
                         <p>Job: ${env.JOB_NAME}</p>
                         <p>Build Number: ${env.BUILD_NUMBER}</p>
                         <p>Check console output at ${env.BUILD_URL}</p>""",
                mimeType: 'text/html'
            )
        }
    }
}

