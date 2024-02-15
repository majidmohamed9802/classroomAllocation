FROM openjdk:17-jdk AS base


EXPOSE 8080

ADD target/springboot-docker.jar springboot-docker.jar


ENTRYPOINT ["java", "-jar", "/springboot-docker.jar"]

