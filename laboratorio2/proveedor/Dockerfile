# -------------------------------------------------------------
# - DOCKERFILE
# - AUTOR: Equipo 5
# - FECHA: 20-Abril-2020
# - DESCRIPCION: Dockerfile que permite la creacion del
# -              contenedor con la aplicacion que gestiona
# -              las cotizaciones
# -------------------------------------------------------------

# escape=\ (backslash)
# Imagen base del Docker Registry para compilar nuestro microservicio
#FROM store/oracle/jdk:11
FROM adoptopenjdk:11-jre-hotspot

# Parametrizacion del nombre del archivo que genera spring boot
ARG JAR_FILE=proveedor-0.0.1-SNAPSHOT.jar
ARG BUILD_DATE
ARG BUILD_VERSION
ARG BUILD_REVISION

ENV APP_HOME="/app" \
    JAVA_OPTS=""
	#HTTP_PORT=8083

# Informacion de la persona que mantiene la imagen
LABEL org.opencontainers.image.created=$BUILD_DATE \
	  org.opencontainers.image.authors="Brian Suarez Botia | Eduardo Franco Rivera | Jhon Celemin Florez | Wilman Ortiz Navarro " \
	  org.opencontainers.image.url="https://gitlab.com/wortiz1027/laboratorio2/-/tree/master/cotizaciones/Dockerfile" \
	  org.opencontainers.image.documentation="" \
	  org.opencontainers.image.source="https://gitlab.com/wortiz1027/laboratorio2/-/tree/master/cotizaciones/Dockerfile" \
	  org.opencontainers.image.version=$BUILD_VERSION \
	  org.opencontainers.image.revision=$BUILD_REVISION \
	  org.opencontainers.image.vendor="javeriana.io" \
	  org.opencontainers.image.licenses="" \
	  org.opencontainers.image.title="Aplicacion de cotizacion para un proveedor" \
	  org.opencontainers.image.description="Imagen docker con la aplicacion que gestiona los sistemas internos de cotizacion de un proveedor."

# Puerto de exposicion del servicio
#EXPOSE $HTTP_PORT

# Creando directorio de la aplicacion
RUN mkdir $APP_HOME && \
    mkdir $APP_HOME/config && \
    mkdir $APP_HOME/log

# RUN apk add --update bash && rm -rf /var/cache/apk/*

# Volumen para el intercambio de archivos con el sistema host
VOLUME $APP_HOME/log \
	   $APP_HOME/config

# Seteando el workspace
WORKDIR $APP_HOME

# Creando un archivo en el contenedor
ADD ./target/$JAR_FILE $APP_HOME/proveedor-service.jar

# Ejecutanto el microservicio en el contenedor
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar ${APP_HOME}/proveedor-service.jar" ]