pipeline {
    agent any
    environment {
        DB_URI = credentials('db-username')
        DB_PASSWORD = credentials('db-password')
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