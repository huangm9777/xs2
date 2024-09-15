FROM openjdk:11.0.2-jdk

COPY xs2-user.jar /xs2-user.jar

ENTRYPOINT ["java", "-jar", "/xs2-user.jar"]

FROM openjdk:11.0.2-jdk

COPY xs2-media.jar /xs2-media.jar

ENTRYPOINT ["java", "-jar", "/xs2-media.jar"]

