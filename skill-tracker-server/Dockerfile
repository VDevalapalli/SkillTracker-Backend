#Start with a base image containing Java Runtime
FROM openjdk:11

#Information about who maintains the image
MAINTAINER skilltracker

ARG JAR_FILE=*.jar

#Add the application jar file to the container
#COPY ${JAR_FILE} skill-tracker-server.jar

COPY build/libs/skill-tracker-server-1.0.0.jar skill-tracker-server.jar

#Start the application
ENTRYPOINT ["java", "-jar", "skill-tracker-server.jar"]
