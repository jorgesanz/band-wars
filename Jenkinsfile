pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {


        stage('Build') {
            steps {
                echo 'Running building automation'
                sh 'mvn -B -DskipTests clean package'
                archiveArtifacts '/target/bandwars.jar'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unitary tests'
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
                    when {
                        branch 'develop'
                    }
                    steps {
                        script {
                            app = docker.build("jorgesanzb/bandwars")
                            app.inside {
                                sh 'echo $(curl localhost:8080)'
                            }
                        }
                    }
                }
                stage('Push Docker Image') {
                    when {
                        branch 'develop'
                    }
                    steps {
                        script {
                            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-login') {
                                app.push("${env.BUILD_NUMBER}")
                                app.push("latest")
                            }
                        }
                    }
                }
                stage('DeployToProduction') {
                    when {
                        branch 'master'
                    }
                    steps {
                        input 'Deploy to Production?'
                        milestone(1)
                        withCredentials([usernamePassword(credentialsId: 'development-server', usernameVariable: 'USERNAME', passwordVariable: 'USERPASS')]) {
                            script {
                                sh "sshpass -p '$USERPASS' -v ssh -o StrictHostKeyChecking=no $USERNAME@$prod_ip \"docker pull jorgesanzb/bandwars:${env.BUILD_NUMBER}\""
                                try {
                                    sh "sshpass -p '$USERPASS' -v ssh -o StrictHostKeyChecking=no $USERNAME@$prod_ip \"docker stop bandwars\""
                                    sh "sshpass -p '$USERPASS' -v ssh -o StrictHostKeyChecking=no $USERNAME@$prod_ip \"docker rm bandwars\""
                                } catch (err) {
                                    echo: 'caught error: $err'
                                }
                                sh "sshpass -p '$USERPASS' -v ssh -o StrictHostKeyChecking=no $USERNAME@$prod_ip \"docker run --restart always --name bandwars -p 8080:8080 -d /bandwars:${env.BUILD_NUMBER}\""
                            }
                        }
                    }
                }
    }
}