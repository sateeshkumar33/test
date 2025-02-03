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
    }
}