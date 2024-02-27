FROM java:8
MAINTAINER willman.ortiz@gmail.com
VOLUME /tmp
EXPOSE 8889
ADD build/libs/springbootdocker-0.0.1-SNAPSHOT.jar springbootdocker.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springbootdocker.jar"]