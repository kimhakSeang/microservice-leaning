#Start with base image containing java runtime
FROM openjdk:17 as build
# Use the official PostgreSQL image from Docker Hub
#FROM postgres:latest

# Information of owner or maintainer of image
MAINTAINER kimhak

# Set environment variables for PostgreSQL
#ENV POSTGRES_DB=mydatabase
#ENV POSTGRES_USER=myuser
#ENV POSTGRES_PASSWORD=mypassword

# Expose PostgreSQL port
#EXPOSE 5432

# Add the application's jar to the container
COPY target/loan-0.0.1-SNAPSHOT.jar loan-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java", "-jar","/loan-0.0.1-SNAPSHOT.jar"]


