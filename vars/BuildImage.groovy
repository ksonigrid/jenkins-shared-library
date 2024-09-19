#!/usr/bin/env groovy

def call(String imageName) {
    echo "building images"
    withCredentials([usernamePassword(credentialsId: "dockerhub-credential", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh """
            docker build . -t $imageName
            echo ${PASS} | docker login -u ${USER} --password-stdin
            docker push $imageName
        """
    }
}