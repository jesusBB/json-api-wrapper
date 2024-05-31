FROM amazoncorretto:17-alpine

LABEL maintainer="epopoola" version="0.1"

RUN mkdir /opt/application

RUN addgroup -g 2000 -S appgroup && adduser -u 1000 -S appuser -G appgroup

WORKDIR /opt/application

RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

COPY target/testing-response-wrapper*.jar app.jar

RUN chown -R 1000:2000 /opt/application

USER 1000

ENTRYPOINT ["java","-javaagent:./dd-java-agent.jar","-Djava.security.egd=file:/dev/./urandom","-jar", "app.jar"]

EXPOSE 8080