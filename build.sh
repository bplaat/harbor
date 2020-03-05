#!/bin/bash
clear
mkdir classes
if javac -Xlint -d classes $(find src -name "*.java"); then
    jar cfe harbor.jar ml.bastiaan.harbor.App -C classes . resources
    rm -r classes
    java -jar harbor.jar
else
    rm -r classes
fi
