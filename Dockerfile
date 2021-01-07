FROM openjdk:latest
COPY ./target/InsuranceApp-0.0.1-SNAPSHOT.jar InsuranceApp-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar","InsuranceApp-0.0.1-SNAPSHOT.jar"]