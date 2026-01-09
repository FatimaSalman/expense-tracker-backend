# firtstly : build project by using Gradle
FROM gradle:8.5-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
# add executing permission to gradlew file
RUN chmod +x ./gradlew
RUN ./gradlew build -x test --no-daemon

# Secondly : run result file
FROM amazoncorretto:17-alpine-jdk
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]