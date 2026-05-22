# Етап 1: Збірка проєкту за допомогою Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Копіюємо pom.xml та завантажуємо залежності (кешування)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Копіюємо вихідний код проєкту (папку src)
COPY src ./src

# Збираємо проєкт та пропускаємо тести для швидкості
RUN mvn package -DskipTests

# Етап 2: Запуск готового додатку
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Копіюємо згенерований jar-файл з попереднього етапу
COPY --from=build /app/target/*.jar app.jar

# Відкриваємо порт 8080 для доступу до додатку
EXPOSE 8080

# Команда для запуску нашого Spring Boot додатку
ENTRYPOINT ["java", "-jar", "app.jar"]