FROM openjdk:11
COPY . app/
WORKDIR app/
RUN ./mvnw clean install
RUN cp target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
