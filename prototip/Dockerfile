# 1. Java 17 ve Maven içeren bir temel görüntü kullanıyoruz
FROM maven:3.9.4-eclipse-temurin-17 AS build

# 2. Çalışma dizinini oluştur
WORKDIR /app

# 3. Proje dosyalarını Docker container içine kopyala
COPY . /app

# 4. Doğru çalışma dizinine geç
WORKDIR /app/prototip

# 5. Maven ile projeyi derle
RUN mvn clean package -DskipTests

# 6. Java 17 içeren bir runtime görüntüsü kullanıyoruz
FROM openjdk:17-jdk-slim

# 7. Çalışma dizinini oluştur
WORKDIR /app

# 8. Derlenen JAR dosyasını kopyala
COPY --from=build /app/prototip/target/*.jar app.jar

# 9. Uygulamayı başlat
CMD ["java", "-jar", "app.jar"]
