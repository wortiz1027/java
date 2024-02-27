FROM java:8
MAINTAINER willman.ortiz@gmail.com
VOLUME /tmp
EXPOSE 3448
ADD build/libs/securityserver-0.0.1-SNAPSHOT.jar securityserver.jar
RUN bash -C 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.edg=file:/dev/./urandom","-jar","/securityserver.jar"]