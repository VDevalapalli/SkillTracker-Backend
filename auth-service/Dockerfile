#Start with a base image containing Java Runtime
FROM openjdk:11

#Information about who maintains the image
MAINTAINER skilltracker

ARG JAR_FILE=*.jar

#Add the application jar file to the container
COPY build/libs/auth-service-1.0.0.jar auth-service.jar

#COPY ${JAR_FILE} auth-service.jar

#Start the application
ENTRYPOINT ["java", "-jar", "auth-service.jar"]
