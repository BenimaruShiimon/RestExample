FROM eclipse-temurin:21-jdk-alpine

EXPOSE 8089

ADD build/libs/Rest_ex-0.0.1-SNAPSHOT.jar rest_app.jar

CMD ["java", "-jar", "rest_app.jar"]