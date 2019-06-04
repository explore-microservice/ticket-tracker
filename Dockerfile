FROM adoptopenjdk/openjdk11:latest
MAINTAINER Me

RUN mkdir /opt/app
COPY target/ticket-tracker-0.0.1-SNAPSHOT.jar /opt/app
WORKDIR /opt/app
CMD ["java", "-jar", "ticket-tracker-0.0.1-SNAPSHOT.jar"]