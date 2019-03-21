FROM java:8
LABEL maintainer=“chathuranga.t@gmail.com”
VOLUME /tmp
EXPOSE 8080
ADD build/libs/spring-rabbitmq-app-0.0.1-SNAPSHOT.jar spring-rabbitmq-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-rabbitmq-app-0.0.1-SNAPSHOT.jar"]