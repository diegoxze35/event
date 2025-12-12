FROM eclipse-temurin:23-jdk-alpine
LABEL authors="diego"
VOLUME /temp
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080