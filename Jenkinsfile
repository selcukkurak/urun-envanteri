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

    stage('Deploy') {
          steps {
            sshagent(credentials: ['ef206fcc-040b-4388-98e9-272bbea3863c']) {
              sh 'rm -rf envanter-deploy'
              sh 'git clone git@git.tuik.gov.tr:dijital-donusum/envanter-deploy.git'

              dir('envanter-deploy') {
                sh "cd ./test && /usr/local/bin/kustomize edit set image dockerhub.tuik.gov.tr/$imageName=dockerhub.tuik.gov.tr/$imageName:$imageVersion"
                sh "git commit -am 'servis yeni sürüm: $imageVersion' && git push || echo 'no changes'"
              }
         }
    }
  }
}