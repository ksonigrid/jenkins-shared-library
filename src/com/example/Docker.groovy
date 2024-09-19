#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {

    def script

    // importing all the jenkins syntax like sh, withCredentials etc.
    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName){
            script.sh "docker build . -t $imageName"
    }

    def dockerLogin(){
        script.withCredentials([script.usernamePassword(credentialsId: "dockerhub-credential", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh """
            echo $script.PASS | docker login -u $script.USER --password-stdin
            echo checking trigger
        """
        }
    }

    def dockerPush(String imageName){
        script.sh "docker push $imageName"
    }
}