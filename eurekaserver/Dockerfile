#Start with base image containing java runtime
FROM openjdk:17 as build
# Use the official PostgreSQL image from Docker Hub
#FROM postgres:latest

# Information of owner or maintainer of image
MAINTAINER kimhak

# Expose PostgreSQL port
#EXPOSE 5432

# Add the application's jar to the container
COPY target/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java", "-jar","/eurekaserver-0.0.1-SNAPSHOT.jar"]


