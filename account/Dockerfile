#Java JDK
FROM openjdk:17 as build

#Maintainer
MAINTAINER Kimhak


#Ad jar file to docker image
COPY target/account-0.0.1-SNAPSHOT.jar account-0.0.1-SNAPSHOT.jar

#Execute app
ENTRYPOINT [ "java", "-jar", "account-0.0.1-SNAPSHOT.jar" ]


## Use Maven base image for building the application
#FROM openjdk:17 as build
#FROM maven:3.8.6-openjdk-17 AS builder
#
#
## Set the working directory
#WORKDIR /app
#
## Build the project
#RUN mvn clean package
#
## Copy the packaged JAR file from the build stage
#COPY target/account-0.0.1-SNAPSHOT.jar account-0.0.1-SNAPSHOT.jar
#
## Command to run the application
#ENTRYPOINT ["java", "-jar", "account-0.0.1-SNAPSHOT.jar"]
