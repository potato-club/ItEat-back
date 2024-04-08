#FROM ubuntu:latest
#LABEL authors="jihye"
#ENTRYPOINT ["top", "-b"]

FROM openjdk:17-jdk AS build
WORKDIR /app
COPY . /app
RUN chmod +x ./gradlew

RUN microdnf install -y findutils
RUN ./gradlew bootJar

RUN ls /app/build/libs

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/build/libs/ItEat-0.0.1-SNAPSHOT-plain.jar"]
