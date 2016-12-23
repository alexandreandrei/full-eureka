FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp

ARG JAR_PATH=

ADD ${JAR_PATH} tasks-service.jar

#RUN sh -c 'touch /tasks-service.jar'

COPY ./tasks-service.jar /

ENV JAVA_OPTS=""
CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /tasks-service.jar" ]

