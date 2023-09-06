pipeline {
  agent { label 'migration' }
  tools {
    maven 'apache-maven-latest'
    jdk 'openjdk-jdk17-latest'
  }
  environment {
    FROM_PR = "${BRANCH_NAME}".contains("PR-");
    
    BUILD_KEY = "${BRANCH_NAME}-${BUILD_ID}".replaceFirst(/^v/, "").replaceAll('/','-');
    
    SSH_ACCOUNT = "genie.egf@projects-storage.eclipse.org"
    BUILD_DIR = "/home/data/httpd/download.eclipse.org/egf/nightly/${BUILD_KEY}"
    
    NIGHTLY_KEY = "${BRANCH_NAME}".replaceFirst(/^v/, "").replaceAll('/','-');
    NIGHTLY_DIR = "/home/data/httpd/download.eclipse.org/egf/nightly/${NIGHTLY_KEY}"
    
    JACOCO_VERSION = "0.8.8"
	JACOCO_EXEC_FILE_PATH = '${WORKSPACE}/jacoco.exec'
  }
  stages {
    stage('Package') {
      steps {
        sh 'env'
        sh 'mvn -Dplatform-version-name=2023-03 clean install -P core -P product -P sign'
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
    stage('Test') {
      steps {
        wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
		  script {
		    def jacocoPrepareAgent = "-Djacoco.destFile=$JACOCO_EXEC_FILE_PATH -Djacoco.append=true org.jacoco:jacoco-maven-plugin:$JACOCO_VERSION:prepare-agent"
		    def ignoreTestFailure = "-Dmaven.test.failure.ignore=true"
		    sh "mvn -Dplatform-version-name=2021-06 ${jacocoPrepareAgent} ${ignoreTestFailure} verify -P tests"
		  }
        }
      }
    }
    stage('Publish tests results') {
	  steps {
		junit allowEmptyResults: true, testResults: '*.xml,**/target/surefire-reports/*.xml'
		sh "mvn -Djacoco.dataFile=$JACOCO_EXEC_FILE_PATH org.jacoco:jacoco-maven-plugin:$JACOCO_VERSION:report -P tests"
	  }
	}
  }
  post {
	always {
	  archiveArtifacts artifacts: '**/*.log, **/*.layout'
	}
  }
}