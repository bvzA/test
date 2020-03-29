FROM openjdk:11-slim AS builder
RUN mkdir /project
ADD . /project
RUN cd /project && ./gradlew clean bootJar

FROM openjdk:11-slim
RUN mkdir /app
COPY  --from=builder /project/build/libs/*.jar  /app/javit.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "javit.jar"]