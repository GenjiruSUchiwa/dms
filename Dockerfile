FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-boot-firestore-example-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring-boot-firestore-example-0.0.1-SNAPSHOT.jar"]