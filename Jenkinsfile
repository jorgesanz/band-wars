pipeline {
    agent any
    stages {
        stage('PRINT') {
            steps {
                sh 'echo $JOB_NAME'
            }
        }
        stage('WRITE') {
            steps {
                sh 'echo $BUILD_NUMBER > build_number'
            }
        }
        stage('READ') {
            steps {
                sh 'cat build_number'
            }
        }
        stage('TEST'){
            steps{
                sh 'mvn test'
            }
        }
        stage('BUILD'){
                    steps{
                        sh 'mvn package'
                    }
             }
        stage('RUN'){
                       steps{
                         sh 'java -jar target/band-manager-1.0-SNAPSHOT.jar'
                    }
              }
    }
    post {
        success {
            archiveArtifacts artifacts: 'build_number', fingerprint: true
        }
     }
}

