FROM java:8u111-jre-alpine
ADD /target/bandwars.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app.jar" ]



