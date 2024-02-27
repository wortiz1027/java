# -------------------------------------------------------------
# - DOCKERFILE
# - AUTOR: ian.beltran@segurosalfa.com.co
# - FECHA: 05-Noviembre-2020
# - DESCRIPCION: Docker compose file que permite la
# -              creacion de 1 contendor para el servicio de 
# -              las transacciones en estado approve y sin notificar a acsele
# -------------------------------------------------------------

# escape=\ (backslash)
# Imagen base del Docker Registry para compilar el componente encargado de gestionar la informacion de las notificaciones
# Build Stage
FROM maven:3.6.3-ibmjava-8-alpine AS builder
WORKDIR /build/
COPY pom.xml .
COPY ./src ./src
RUN mvn clean package -Dmaven.test.skip=true

# Run Stage
FROM openjdk:8-jre-alpine

# Parametrizacion del nombre del archivo que genera spring boot
ARG JAR_FILE=notificationsrecurring-service.jar
ARG BUILD_DATE
ARG BUILD_VERSION
ARG BUILD_REVISION

ENV APP_HOME="/app" \
	UPLOAD_DIR="/tmp/upload" \
	JAVA_OPTS="" \
	HTTP_PORT=8089

# Creando directorios de la aplicacion y de carga temporal de los archivos
RUN mkdir $APP_HOME && mkdir -p $UPLOAD_DIR
	
# Informacion de la persona que mantiene la imagen
LABEL org.opencontainers.image.created=$BUILD_DATE \
	  org.opencontainers.image.authors="Ian Beltran" \
	  org.opencontainers.image.url="https://github.com/wortiz1027/alfa-notificationsrecurring/blob/master/Dockerfile" \
	  org.opencontainers.image.documentation="" \
	  org.opencontainers.image.source="https://github.com/wortiz1027/alfa-notificationsrecurring/blob/master/Dockerfile" \
	  org.opencontainers.image.version=$BUILD_VERSION \
	  org.opencontainers.image.revision=$BUILD_REVISION \
	  org.opencontainers.image.vendor="Seguros Alfa | https://www.segurosalfa.com.co/" \
	  org.opencontainers.image.licenses="" \
	  org.opencontainers.image.title="Componente encargado de gestionar la informacion de las notificaciones" \
	  org.opencontainers.image.description="Componente encargado de gestionar la informacion de las notificaciones que llegan desde acsel-e, en el cual registra si la notificación se genero, necesita reintentos"

# Puerto de exposicion del servicio
EXPOSE $HTTP_PORT

# Copiando el compilado desde builder
COPY --from=builder /build/target/$JAR_FILE $APP_HOME/

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar ${APP_HOME}/notificationsrecurring-service.jar"]
