pipeline{
    agent any

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
            }
        }
    }
}
