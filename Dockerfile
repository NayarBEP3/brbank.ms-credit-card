FROM openjdk:21-jdk
WORKDIR /app
COPY ./target/ms-credit-card-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
CMD ["java", "-jar", "ms-credit-card-0.0.1-SNAPSHOT.jar"]