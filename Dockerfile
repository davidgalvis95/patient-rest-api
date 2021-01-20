FROM openjdk:11-jre-slim
VOLUME /tmp
EXPOSE 8080
ADD target/technical-test-0.0.1-SNAPSHOT.jar technical-test-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","technical-test-0.0.1-SNAPSHOT.jar"]