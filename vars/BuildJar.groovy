#!/usr/bin/env groovy

def call() {
    echo "building Jar"
    sh "mvn package"
}