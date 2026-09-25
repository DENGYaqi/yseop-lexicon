FROM public.ecr.aws/docker/library/maven:3.6.3-jdk-8
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn -q -DskipTests package
CMD ["java", "-jar", "target/com.yseop.lexicon.web-0.0.1-SNAPSHOT.jar"]
