FROM openjdk:8-jre
COPY target/*.jar /usr/app/
WORKDIR /usr/app
CMD [ "java", "-jar", "contacto-cero-web-0.0.1-SNAPSHOT.jar" ] 