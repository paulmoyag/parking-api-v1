FROM adoptopenjdk/openjdk13-openj9:jdk-13.0.2_8_openj9-0.18.0-alpine-slim
WORKDIR /app
COPY ./ /app
EXPOSE 8080
RUN chmod +x gradlew && ./gradlew build --no-daemon
RUN mv /app/build/libs/*-all.jar app.jar
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
