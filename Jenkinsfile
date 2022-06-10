pipeline {
    agent any
    
     environment {
        String branchName = "main"
        String repoUrl = "https://github.com/YounessT28/LoginSpring.git"
        registry = "youness/shop"
        registryCredential = 'dockerhub'
    	app = ''
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    sh("pwd")
                    sh("ls -ahl")
                    echo 'Cloning files from (branch: "' + branchName + '" )'
                    echo 'Start cloning the github repository from (branch: "' + branchName + ' ") .....'
                    // The below will clone your repo and will be checked out to master branch by default.
                    git branch: branchName, url: repoUrl
                    sh("ls -ahl")
                    echo 'repository clone on branch master done.'
                }
            }
		}
		stage('Compile') {
            steps {
                script {
                    echo 'compiling'
                    sh("mvn compile")
                    echo 'compile success'
                }
            }
        }
		stage('Test') {
            steps {
                script {
                    echo 'starting spring boot application unit test .....'
                    sh("mvn test")
                    echo 'spring boot application unit tests passed'
                }
            }
        }
        stage('Javadoc') {
            steps {
                script {
                    echo 'generating doc'
                    sh("mvn javadoc:javadoc")
                    echo 'doc generated'
                }
            }
        }
	 }
	 post {
    failure  
    {
        mail to: 'youness.t28100@gmail.com',               
                    subject: "Job $JOB_NAME failed" ,
                    body: """Build $BUILD_NUMBER failed.    
Go to $BUILD_URL for more info."""
    }
    }
}
