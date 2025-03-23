pipeline {
  agent any
 
  tools {
  maven 'Maven3'
  }
  stages {
    stage ('Build') {
      steps {
      sh 'mvn clean package -f MyWebApp/pom.xml'
      }
    }
    // stage ('Code Quality') {
    //   steps {
    //     withSonarQubeEnv('SonarQube') {
    //     sh 'mvn -f MyWebApp/pom.xml sonar:sonar'
    //     }
    //   }
    // }
    stage ('JaCoCo') {
      steps {
      jacoco()
      }
    }
    // stage ('Nexus Upload') {
    //   steps {
    //   nexusArtifactUploader(
    //   nexusVersion: 'nexus3',
    //   protocol: 'http',
    //   nexusUrl: 'nexus_url:8081',
    //   groupId: 'myGroupId',
    //   version: '1.0-SNAPSHOT',
    //   repository: 'maven-snapshots',
    //   credentialsId: 'fc0f1694-3036-41fe-b3e3-4c5d96fcfd26',
    //   artifacts: [
    //   [artifactId: 'MyWebApp',
    //   classifier: '',
    //   file: 'MyWebApp/target/MyWebApp.war',
    //   type: 'war']
    //   ])
    //   }
    // }

    stage ('Prd Approve') {
      steps {
      echo "Taking approval from DEV Manager for QA Deployment"
        timeout(time: 7, unit: 'DAYS') {
        input message: 'Do you want to deploy?', submitter: 'admin'
        }
      }
    }    
    
    stage ('Prd Deploy') {
      steps {
      echo "deploying to DEV Env "
      deploy adapters: [tomcat9(credentialsId: '61f7d24f-469f-4366-9dc8-3ec3e3cfc1de', path: '', url: 'http://ec2-3-87-1-137.compute-1.amazonaws.com:8080/')], contextPath: null, war: '**/*.war'
      }
    }
    // stage ('Slack Notification') {
    //   steps {
    //     echo "deployed to DEV Env successfully"
    //     slackSend(channel:'your slack channel_name', message: "Job is successful, here is the info - Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
    //   }
    // }

   }
    post {
        always {
            // Clean up workspace
            cleanWs()
        }
        success {
            // Notify success (you can add email or Slack notifications here)
            echo "Build and deployment successful."
        }
        failure {
            // Notify failure
            echo "Build or deployment failed."
        }
    }
}
