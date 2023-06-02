FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} kubeprac.jar

ENTRYPOINT ["java", "-jar", "/kubeprac.jar"]

EXPOSE 9001
