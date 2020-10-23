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
                    sh 'mvn clean test compile package'
            }
        }
//         stage ('Deployment Stage'){
//             steps{
//                     sh 'mvn package'
//                     sh 'cp target/helloworld.jar /Users/cesarvalencia/desktop/tools/tomcat/webapps/'
//                     mail (body:
//                                 "Pipeline error: Fix me.",
//                                 from: 'cesar.valencia49@gmail.com',
//                                 subject: 'Pipeline build failed',
//                                 to: 'cesar.valencia49@gmail.com')
//             }
//         }
        stage("Docker: Build image"){
            steps{
                        sh "docker build -t cvalenciadocker123/helloworld ."
            }

        }
        stage("Docker: push image"){
            steps{
                withCredentials([string(credentialsId: 'DOCKER_HUB_CREDENTIALS', variable: 'DOCKER_HUB_CREDENTIALS')]){
                    sh "docker login -u cvalenciadocker123 -p ${DOCKER_HUB_CREDENTIALS}"
                }
                sh "docker push cvalenciadocker123/helloworld"

            }
        }

        stage("Deploy application in Kubernetes Cluster"){
            steps{
                kubernetesDeploy(
                    configs: 'deployment.yml',
                    kubeconfigId:  'KUBERNETES_CLUSTER_CONFIG',
                    enableConfigSubstitution: true
                )
            }
        }
    }
}
