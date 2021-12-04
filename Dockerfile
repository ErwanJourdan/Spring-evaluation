FROM maven:3-openjdk-17-slim
COPY . /springEvaluation
RUN cd /springEvaluation/ && mvn -DskipTests clean package
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/springEvlaluation/target/springDemo-0.0.1-SNAPSHOT.jar"]


