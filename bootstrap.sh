#!/bin/sh
JAR_FILE=build/libs/*.jar
gradle clean bootJar
cp $JAR_FILE /app/app.jar
java -jar /app/app.jar