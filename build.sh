#!/bin/bash
clear
mkdir classes
if javac -Xlint -d classes $(find src -name "*.java"); then
    jar cfe containership.jar ml.bastiaan.containership.App -C classes .
    java -jar containership.jar
fi
rm -r classes
