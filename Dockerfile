FROM maven:3-openjdk-17-slim
COPY . /springDemo
RUN cd /springDemo/ && mvn -DskipTests clean package
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/springDemo/target/springDemo-0.0.1-SNAPSHOT.jar"]

