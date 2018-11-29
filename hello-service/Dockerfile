FROM openjdk:8-jdk-alpine

ADD target/hello-0.0.1-SNAPSHOT.jar app.jar

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.4.0/wait /wait
RUN chmod +x /wait

## Launch the wait tool and then your application
CMD /wait && java -Djava.security.egd=file:/dev/./urandom -Dspring.cloud.config.uri=http://config-server:8888 -jar /app.jar