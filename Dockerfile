# Etapa 1: Build do JAR
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

# Copia arquivos do projeto
COPY pom.xml .
COPY src ./src

# Build do JAR sem rodar testes
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o JAR gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Variável de porta do Render
ENV PORT 8081
ENV JAVA_OPTS=""

# Comando para rodar o Spring Boot
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dserver.port=$PORT -jar app.jar"]


