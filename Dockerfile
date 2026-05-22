# Paso 1: Construir la aplicación usando Maven con Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Paso 2: Ejecutar la aplicación con un entorno ligero de Java 21
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8098
ENTRYPOINT ["java", "-jar", "app.jar"]