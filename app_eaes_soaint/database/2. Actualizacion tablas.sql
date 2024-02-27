ALTER TABLE COLABORADOR 
ADD DISPONIBLE VARCHAR2(1);

ALTER TABLE curriculum
drop column nivel_Academico;

ALTER TABLE curriculum
drop column titulo_Academico;

ALTER TABLE prototipo 
ADD presupuesto number(10,2);

--Tabla COLABORADORPROTOTIPO
CREATE TABLE colaboradorprototipo(
  id_colaboradorprototipo NUMBER GENERATED ALWAYS AS IDENTITY,
  id_prototipo NUMBER,
  id_colaborador NUMBER,
  estado VARCHAR2(20),
  CONSTRAINT colaboradorprototipo_pk PRIMARY KEY (id_colaboradorprototipo),
  CONSTRAINT fk_colaboradorprototipo_prototipo
    FOREIGN KEY (id_prototipo)
    REFERENCES prototipo(id_prototipo),
  CONSTRAINT fk_colaboradorprototipo_colaborador
    FOREIGN KEY (id_colaborador)
    REFERENCES colaborador(id_colaborador)
);

--Tabla contrato
CREATE TABLE CONTRATO(
	ID_CONTRATO NUMBER GENERATED ALWAYS AS IDENTITY,
	ID_COLABORADOR NUMBER, 
	VALOR NUMBER(10,2), 
	TIPO VARCHAR2(20), 
	FECHA_INICIO DATE, 
	FECHA_FIN DATE, 
	 CONSTRAINT CONTRATO_PK PRIMARY KEY (ID_CONTRATO),
	 CONSTRAINT fk_CONTRATO_colaborador
		FOREIGN KEY (id_colaborador)
		REFERENCES colaborador(id_colaborador)
	 );

--Tabla TrazabilidadContratacion
CREATE TABLE TrazabilidadContratacion(
	ID_TRAZABILIDADCONTRATACION NUMBER GENERATED ALWAYS AS IDENTITY,
	ID_CANDIDATO NUMBER, 
	EVENTO NUMBER,
	FECHA_EVENTO DATE, 
	FECHA_FIN DATE, 
	 CONSTRAINT TRAZABILIDADCONTRATACION_PK PRIMARY KEY (ID_TRAZABILIDADCONTRATACION),
	 CONSTRAINT fk_TRAZABILIDADCONTRATACION_CANDIDATO
		FOREIGN KEY (ID_CANDIDATO)
		REFERENCES CANDIDATO(ID_CANDIDATO)
	 );
	 
COMMIT;