pipeline {
    agent any
    environment {
        DB_URI = credentials('DB_URI')
        SPRING_PROFILES_ACTIVE = credentials('SPRING_PROFILES_ACTIVE')
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
                            def imageName = "demo-image:${buildNumber}"
                            echo "🔹 BUILD_NUMBER: ${buildNumber}"   // Print build number
                            echo "🔹 Docker Image Name: ${imageName}" // Print image name

                            withCredentials([usernamePassword(credentialsId: 'DOCKER_REGISTRY_CREDENTIALS',
                                                                          usernameVariable: 'DOCKER_USER',
                                                                          passwordVariable: 'DOCKER_PASS')]) {
                                            sh """
                                                docker build -t ${imageName} .  # Build with new changes
                                                docker tag ${imageName} demo-image:latest  # Optional: Update latest tag
                                                echo "${DOCKER_PASS}" | docker login -u "${DOCKER_USER}" --password-stdin
                                                docker push ${imageName}  # Push new build
                                                docker push demo-image:latest  # Push latest tag
                                            """
                            }
                        }
                    }
                }
    }
}