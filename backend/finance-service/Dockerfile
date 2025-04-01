FROM eclipse-temurin:21-jdk-alpine

#pega o jar gerado pelo maven e copia para o container na pasta app
COPY target/ai-finance-0.0.1-SNAPSHOT.jar /app/app.jar
#Esse comando é executado quando o container é iniciado
CMD ["java", "-jar", "/app/app.jar"]

