#!/usr/bin/env groovy

def call() {
    echo "building images"
    withCredentials([usernamePassword(credentialsId: "dockerhub-credential", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh """
            docker build . -t ksonigrid/java-mavenrepo:2.0
            echo ${PASS} | docker login -u ${USER} --password-stdin
            docker push ksonigrid/java-mavenrepo:2.0
        """
    }
}