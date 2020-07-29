@Library('docker-shared-lib@master') _

pipeline {
  agent any
  environment {
    imageName = ''
    imageVersion = ''
    grup = 'ybs_envanter'
    CI = 'true'
  }

  post {
    success {
      roket(grup: grup, imaj: "$imageName:$imageVersion")
    }

    failure {
      roket(grup: grup, fail: true)
    }
  }

  stages {
    stage('Derleme') {
      steps {
        script {
          def properties = projectProperties()
          imageName = 'tuik/' + properties.name
          imageVersion = properties.version + "-$BUILD_NUMBER"
        }
        mavenBuild(
            mavenImage: 'dockerhub.tuik.gov.tr/tuik/jenkins-maven:3.6.3-adoptopenjdk-11',
        )
      }
    }

    stage('Docker') {
      steps {
        dockerBuild(imageName: imageName, version: imageVersion)
      }
    }
  }
}