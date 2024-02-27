----------------------------------------
--Tabla ROL
CREATE TABLE rol
( id_rol NUMBER GENERATED ALWAYS AS IDENTITY,
  nombre varchar2(50) NOT NULL,
  descripcion varchar2(50),
  CONSTRAINT rol_pk PRIMARY KEY (id_rol)
);

--Tabla VACANTE
CREATE TABLE vacante
( id_vacante NUMBER GENERATED ALWAYS AS IDENTITY,
  nombre varchar2(50),
  estado varchar2(20),
  descripcion varchar2(100),
  CONSTRAINT vacante_pk PRIMARY KEY (id_vacante)
);

--Tabla CANDIDATO
CREATE TABLE candidato
( id_candidato NUMBER GENERATED ALWAYS AS IDENTITY,
  primer_nombre varchar2(20) NOT NULL,
  segundo_nombre varchar2(20),
  primer_apellido varchar2(20) NOT NULL,
  segundo_apellido varchar2(20),
  tipo_identificacion varchar2(2) NOT NULL,
  numero_identificacion varchar2(20) NOT NULL,
  email varchar2(20),
  telefono varchar2(20),
  fecha_nacimiento DATE NOT NULL,
  CONSTRAINT candidato_pk PRIMARY KEY (id_candidato)
);

--Tabla Colaborador
CREATE TABLE colaborador
( id_colaborador NUMBER GENERATED ALWAYS AS IDENTITY,
  id_rol NUMBER,
  primer_nombre varchar2(20) NOT NULL,
  segundo_nombre varchar2(20),
  primer_apellido varchar2(20) NOT NULL,
  segundo_apellido varchar2(20),
  email varchar2(20),
  telefono varchar2(20),
  CONSTRAINT colaborador_pk PRIMARY KEY (id_colaborador),
  CONSTRAINT fk_rol_colaborador
    FOREIGN KEY (id_rol)
    REFERENCES rol(id_rol)
);

--Tabla CURRICULUM
CREATE TABLE curriculum
( id_curriculum NUMBER GENERATED ALWAYS AS IDENTITY,
  id_candidato NUMBER,
  id_documento varchar2(20) NOT NULL,
  nivel_academico varchar2(20),
  titulo_academico varchar2(20),
  CONSTRAINT curriculum_pk PRIMARY KEY (id_curriculum),
  CONSTRAINT fk_candidato_curriculum
    FOREIGN KEY (id_candidato)
    REFERENCES candidato(id_candidato)
);

--Tabla ENTREVISTA
CREATE TABLE entrevista
( id_entrevista NUMBER GENERATED ALWAYS AS IDENTITY,
  id_curriculum NUMBER,
  id_colaborador NUMBER,
  id_vacante NUMBER,
  fecha_realizacion DATE,
  resultado varchar2(20),
  fecha_emision_resultado DATE,
  observaciones varchar2(100),
  CONSTRAINT entrevista_pk PRIMARY KEY (id_entrevista),
  CONSTRAINT fk_entrevista_curriculum
    FOREIGN KEY (id_curriculum)
    REFERENCES curriculum(id_curriculum),
  CONSTRAINT fk_entrevista_colaborador
    FOREIGN KEY (id_colaborador)
    REFERENCES colaborador(id_colaborador),
  CONSTRAINT fk_entrevista_vacante
    FOREIGN KEY (id_vacante)
    REFERENCES vacante(id_vacante)
);

--Tabla PROTOTIPO
CREATE TABLE prototipo
( id_prototipo NUMBER GENERATED ALWAYS AS IDENTITY,
  titulo varchar2(50) NOT NULL,
  fecha_inicio DATE,
  fecha_cierre DATE,
  detalle varchar2(2000),
  estado varchar2(20),
  CONSTRAINT prototipo_pk PRIMARY KEY (id_prototipo)
);

--Tabla FASE
CREATE TABLE fase
( id_fase NUMBER GENERATED ALWAYS AS IDENTITY,
  id_prototipo NUMBER,
  fecha_inicio DATE,
  fecha_fin DATE,
  CONSTRAINT fase_pk PRIMARY KEY (id_fase),
  CONSTRAINT fk_fase_prototipo
    FOREIGN KEY (id_prototipo)
    REFERENCES prototipo(id_prototipo)
);

--Tabla RECOMENDACION
CREATE TABLE recomendacion
( id_recomendacion NUMBER GENERATED ALWAYS AS IDENTITY,
  id_prototipo NUMBER,
  observacion varchar2(2000),
  CONSTRAINT recomendacion_pk PRIMARY KEY (id_recomendacion),
  CONSTRAINT fk_recomendacion_prototipo
    FOREIGN KEY (id_prototipo)
    REFERENCES prototipo(id_prototipo)
);

--Tabla PROBLEMA
CREATE TABLE problema
( id_problema NUMBER GENERATED ALWAYS AS IDENTITY,
  id_prototipo NUMBER,
  fecha_incidencia DATE,
  observacion varchar2(2000),
  CONSTRAINT problema_pk PRIMARY KEY (id_problema),
  CONSTRAINT fk_problema_prototipo
    FOREIGN KEY (id_prototipo)
    REFERENCES prototipo(id_prototipo)
);
COMMIT;