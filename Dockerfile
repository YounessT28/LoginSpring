FROM maven:3.8.4-openjdk-11-slim as build
RUN mkdir shop
WORKDIR /shop
COPY ./ ./
RUN mvn clean package spring-boot:repackage
RUN ls
RUN ls ./target

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build /shop/target/*.jar /jar-files/shop.jar
WORKDIR /jar-files

EXPOSE 8080
CMD [ "java", "-jar", "-Dspring.profiles.active=prod", "shop.jar" ]