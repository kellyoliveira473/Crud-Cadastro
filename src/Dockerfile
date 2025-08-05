FROM ubuntu:latest As build

RUN apt-get update
RUN apt-get install openjdk-20-jdk -y
WORKDIR /app
COPY . .
RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:20-slim
EXPOSE 8080
WORKDIR /app
COPY --from=build /app/target/padaria-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
