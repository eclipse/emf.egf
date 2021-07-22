pipeline {
  agent { label 'migration' }
  tools {
    maven 'apache-maven-latest'
    jdk 'oracle-jdk8-latest'
  }
  environment {
    FROM_PR = "${BRANCH_NAME}".contains("PR-");
    
    BUILD_KEY = "${BRANCH_NAME}-${BUILD_ID}".replaceFirst(/^v/, "").replaceAll('/','-');
    
    SSH_ACCOUNT = "genie.egf@projects-storage.eclipse.org"
    BUILD_DIR = "/home/data/httpd/download.eclipse.org/egf/nightly/${BUILD_KEY}"
    
    NIGHTLY_KEY = "${BRANCH_NAME}".replaceFirst(/^v/, "").replaceAll('/','-');
    NIGHTLY_DIR = "/home/data/httpd/download.eclipse.org/egf/nightly/${NIGHTLY_KEY}"
  }
  stages {
    stage('Package') {
      steps {
        sh 'env'
        sh 'mvn -Dplatform-version-name=2019-06 clean install -P core -P sign'
      }
    }
    stage('Publish artifacts') {
      steps {
        sshagent ( ['projects-storage.eclipse.org-bot-ssh']) {
          sh "ssh $SSH_ACCOUNT mkdir -p $BUILD_DIR/"
          sh "scp -rp $WORKSPACE/releng/org.eclipse.egf.core.updatesite/target/repository/* $SSH_ACCOUNT:$BUILD_DIR/"
        }
        script {    
          currentBuild.description = "${BUILD_KEY} - <a href=\"https://download.eclipse.org/egf/nightly/${BUILD_KEY}\">site</a>"         
        }
      }
    }
    stage('Publish nightly') {
      when {
        expression {
          !"${BRANCH_NAME}".contains('PR-')
        }
      }
      steps {
        sshagent ( ['projects-storage.eclipse.org-bot-ssh']) {
          sh "ssh ${SSH_ACCOUNT} mkdir -p ${NIGHTLY_DIR}"
          sh "ssh ${SSH_ACCOUNT} cp -r ${BUILD_DIR}/ ${NIGHTLY_DIR}"
        }
      }
    }
  }
}