FROM maven:3.6.0-jdk-11-slim AS build

COPY ./src /usr/src/app/src
COPY ./pom.xml /usr/src/app

RUN mvn -f /usr/src/app/pom.xml de.qaware.maven:go-offline-maven-plugin:resolve-dependencies
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM openjdk:8-jre

EXPOSE 8080
COPY --from=build /src/usr/src/app/target/julie-*.jar julie.jar
ENTRYPOINT ["java","-jar","julie.jar"]