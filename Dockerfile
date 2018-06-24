FROM openjdk:8-jdk-alpine

MAINTAINER Laijin Lu <1@aikin.me>

COPY build/libs/bicyclestore-bicycle-service.jar /app/bicyclestore-bicycle-service.jar

WORKDIR /app

CMD ["java", "-jar", "-Xmx2048m", "bicyclestore-bicycle-service.jar"]
