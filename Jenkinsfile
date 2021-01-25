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
        mavenBuild()
      }
    }

    stage('Docker') {
      steps {
        dockerBuild(imageName: imageName, version: imageVersion)
      }
    }

    stage('Deploy') {
      steps {
        deployArgo(
          imageName: imageName,
            imageVersion: imageVersion,
            message: "api sürüm güncelle: $imageVersion",
            deployUrl:'git@git.tuik.gov.tr:dijital-donusum/envanter-deploy.git'
        )
      }
    }
  }
}