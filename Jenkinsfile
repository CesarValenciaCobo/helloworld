pipeline{
    agent any
    environment {
        EMAIL_TO = 'cesar.valencia49@gmail.com'
    }
    stages{
        stage ('Compile Stage'){
            steps{
                    sh 'mvn clean compile'
            }
        }
        stage ('Testing Stage'){
            steps{
                    sh 'mvn test'
            }
        }
        stage ('Deployment Stage'){
            steps{
                    sh 'mvn deploy'
                    sh 'cp target/helloworld.war /Users/cesarvalencia/desktop/tools/tomcat/webapps/'
                    emailext body: 'Deployment when ok',
                                        to: "${EMAIL_TO}",
                                        subject: 'Build failed in Jenkins: $PROJECT_NAME - #$BUILD_NUMBER'
            }
        }
    }
}
