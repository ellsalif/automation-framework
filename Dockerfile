
FROM alpine/java:22-jdk
COPY ./ ./
RUN addgroup -S test && adduser -S test -G test
USER test:test
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=test", "-jar", "/app.jar"]