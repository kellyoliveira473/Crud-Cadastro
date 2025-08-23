# Etapa de Build
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Imagem final
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# Variáveis do Render
ENV JAVA_OPTS=""

# Comando para rodar Spring Boot
ENTRYPOINT sh -c "java $JAVA_OPTS -Dserver.port=$PORT -jar app.jar"


