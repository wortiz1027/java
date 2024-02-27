# -------------------------------------------------------------
# - DOCKERFILE
# - AUTOR: Brian Suarez | Eduardo Franco | Jhon Celemin | Wilman Ortiz
# - FECHA: 24-Octubre-2020
# - DESCRIPCION: Dockerfile que permite la creacion de las
# -              instancias en el servidor de bpm
# -------------------------------------------------------------

# escape=\ (backslash)
# Imagen base del Docker Registry para compilar nuestra servicio de booking AA
# Build Stage
FROM maven:3.6.3-jdk-11-slim AS BUILDER
WORKDIR /build/
COPY pom.xml .
COPY ./src ./src
RUN mvn clean package -Dmaven.test.skip=true

# Run Stage
FROM adoptopenjdk:11-jre-hotspot

ENV APP_HOME "/app"
ENV HTTP_PORT 8099

# Informacion de la persona que mantiene la imagen
LABEL org.opencontainers.image.created=$BUILD_DATE \
	  org.opencontainers.image.authors="Brian Suarez | Eduardo Franco | Jhon Celemin | Wilman Ortiz Navarro " \
	  org.opencontainers.image.url="https://gitlab.com/bcamilo/paywaoint-service/-/blob/master/Dockerfile" \
	  org.opencontainers.image.documentation="" \
	  org.opencontainers.image.source="https://gitlab.com/bcamilo/paywaoint-service/-/blob/master/Dockerfile" \
	  org.opencontainers.image.version=$BUILD_VERSION \
	  org.opencontainers.image.revision=$BUILD_REVISION \
	  org.opencontainers.image.vendor="Pontificia Universidad Javeriana | https://www.javeriana.edu.co/" \
	  org.opencontainers.image.licenses="" \
	  org.opencontainers.image.title="Servicio rest se encarga de iniciar las intancias en el bpm" \
	  org.opencontainers.image.description="El siguiente servicio tiene como finalidad gestionar el inicio de las intancias en el bpm de ibm"

# Puerto de exposicion del servicio
EXPOSE $HTTP_PORT

# Creando directorio de la aplicacion
RUN mkdir $APP_HOME

# Seteando el workspace
WORKDIR $APP_HOME

COPY --from=BUILDER /build/target/bpm-command-services.jar ${APP_HOME}

ENTRYPOINT ["java","-jar","/app/bpm-command-services.jar"]