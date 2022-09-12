FROM openjdk:17-oracle
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 8080
# ENTRYPOINT ["java","-jar","/app.jar"]
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo/test", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]