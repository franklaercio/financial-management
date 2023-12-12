FROM maven:3.9.5-eclipse-temurin-21 AS build
RUN mkdir /src
COPY . /src
WORKDIR /src
RUN mvn clean install -DskipTests

FROM eclipse-temurin:21.0.1_12-jdk

ENV MYSQL_URL="jdbc:mysql://db:3306/wallet" MYSQL_USERNAME="root" MYSQL_PASSWORD="123456"

EXPOSE 8080
ENV TZ="America/Sao_Paulo"
RUN mkdir /app
COPY --from=build /src/target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]