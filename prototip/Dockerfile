# 1. Java 17 ve Maven içeren bir temel görüntü kullanıyoruz
FROM maven:3.8.6-openjdk-17 AS build

# 2. Çalışma dizinini oluştur
WORKDIR /app

# 3. Proje dosyalarını konteynerin içine kopyala
COPY . .

# 4. Maven ile projeyi derle
RUN mvn clean package -DskipTests

# 5. Java 17 içeren bir runtime görüntüsü kullanıyoruz
FROM openjdk:17-jdk-slim

# 6. Çalışma dizinini oluştur
WORKDIR /app

# 7. Derlenen JAR dosyasını kopyala
COPY --from=build /app/target/*.jar app.jar

# 8. Uygulamayı başlat
CMD ["java", "-jar", "app.jar"]