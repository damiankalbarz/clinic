FROM maven:3.8.3-openjdk-17


VOLUME /tmp

COPY src /home/app/src
COPY pom.xml /home/app
COPY target/*.jar app.jar

RUN mvn -f /home/app/pom.xml

ENTRYPOINT ["java", "-jar", "/app.jar"]
