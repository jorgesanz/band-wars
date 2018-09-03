FROM java:8u111-jre-alpine

MAINTAINER Dersu Uzala

ADD /target/band-manager-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]