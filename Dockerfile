FROM openjdk:11-jre-slim as builder
COPY ./target/technical-test-0.0.1-SNAPSHOT.jar technical-test-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","technical-test-0.0.1-SN.jar"]