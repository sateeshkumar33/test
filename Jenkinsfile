pipeline {
    agent any
    environment {
        DB_URI = credentials('DB_URI')
        SPRING_PROFILES_ACTIVE = credentials('SPRING_PROFILES_ACTIVE')
        DOCKER_REGISTRY_CREDENTIALS = credentials('DOCKER_REGISTRY_CREDENTIALS')
    }
    stages {
        stage('Build') {
            steps {
                // Run your build command (e.g., Maven or Gradle)
                sh 'mvn clean package'
            }
        }
        stage('Archive') {
            steps {
                // Archive the JAR file
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
        stage('Build Docker Image') {
                    steps {
                        script {
                            def buildNumber = env.BUILD_NUMBER
                            def imageName = "your-docker-image-name:${buildNumber}"

                            sh """
                                docker build -t ${imageName} .
                                docker login -u ${DOCKER_REGISTRY_CREDENTIALS_USR} -p ${DOCKER_REGISTRY_CREDENTIALS_PSW}
                                docker push ${imageName}
                            """
                        }
                    }
                }
    }
}