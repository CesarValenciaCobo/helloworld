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
                    mail (body:
                                "Pipeline error: Fix me.",
                                from: 'cesar.valencia49@gmail.com',
                                subject: 'Pipeline build failed',
                                to: 'cesar.valencia49@gmail.com')
            }
        }
    }
}
