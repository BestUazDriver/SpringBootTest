FROM openjdk:17-oracle
WORKDIR /app
COPY mvnw /mvnw
COPY . .
RUN sed -i 's/\r$//' mvnw
RUN ./mvnw clean install -DskipTests
EXPOSE 8081:80