#!/usr/bin/env groovy

def call() {
    echo "building Jar for branch $BRANCH_NAME"
    sh "mvn package"
}