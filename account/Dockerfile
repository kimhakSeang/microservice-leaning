#Java JDK
FROM openjdk:17 as build

#Maintainer
MAINTAINER Kimhak

#Add jar file to docker image
COPY target/account-0.0.1-SNAPSHOT.jar account-0.0.1-SNAPSHOT.jar


#Execute app
ENTRYPOINT [ "java", "-jar", "account-0.0.1-SNAPSHOT.jar" ]