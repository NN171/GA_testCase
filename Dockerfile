FROM eclipse-temurin:17.0.12_7-jre-jammy
ARG JAR_FILE=target/*.jar
COPY ./target/*.jar greenatom.jar
ENTRYPOINT ["java", "-jar", "/greenatom.jar"]