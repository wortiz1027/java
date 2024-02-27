-- Base de datos que permite gestionar booking de American AirLine
DROP SCHEMA IF EXISTS dancarltondb ;

-- Creando la base de datos para booking
CREATE DATABASE IF NOT EXISTS dancarltondb;
USE dancarltondb;

-- Creando tablas
CREATE TABLE IF NOT EXISTS dancarltondb.reserva (
    idReserva       BIGINT         NOT NULL,
    codigoReserva	VARCHAR(100)   NOT NULL,
    fechaInicio     DATETIME       NOT NULL,
    fechaFin        DATETIME       NOT NULL,
    nombreHuesped   VARCHAR(200)   NOT NULL,
    tienePasaporte  VARCHAR(1)     NOT NULL,
    numeroPasaporte VARCHAR(200),
    numeroDocumento VARCHAR(200)   NOT NULL,
    observaciones   VARCHAR(1000)  NOT NULL,
    tipoHabitacion  BIGINT         NOT NULL
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS dancarltondb.tipo_habitacion (
    id_tipo     BIGINT       NOT NULL,
    descripcion VARCHAR(256) NOT NULL
)ENGINE = InnoDB;

-- Creando llaves primarias
-- ALTER TABLE dancarltondb.reserva ADD CONSTRAINT PRIMARY KEY pk_reserva (idReserva);

ALTER TABLE dancarltondb.reserva MODIFY idReserva BIGINT AUTO_INCREMENT PRIMARY KEY;

-- ALTER TABLE dancarltondb.tipo_habitacion ADD CONSTRAINT PRIMARY KEY pk_tipo (id_tipo);
ALTER TABLE dancarltondb.tipo_habitacion MODIFY id_tipo BIGINT AUTO_INCREMENT PRIMARY KEY;

-- Creando llaves secundarias
ALTER TABLE dancarltondb.reserva ADD FOREIGN KEY (tipoHabitacion) REFERENCES dancarltondb.tipo_habitacion(id_tipo);

-- INSERTS
SET @MIN_INIT = '2020-01-01 00:00:00';
SET @MAX_INIT = '2020-12-31 23:59:59';

SET @MIN_END = '2021-01-01 00:00:00';
SET @MAX_END = '2021-12-31 23:59:59';

INSERT INTO dancarltondb.tipo_habitacion VALUES (default, 'Simple');
INSERT INTO dancarltondb.tipo_habitacion VALUES (default, 'Doble');
INSERT INTO dancarltondb.tipo_habitacion VALUES (default, 'Matrimonial');

INSERT INTO dancarltondb.reserva VALUES (default, 'A157BX', TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_INIT, @MAX_INIT)), @MIN_INIT), TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_END, @MAX_END)), @MIN_END), 'Manuel Perez Conrado', 'S', 'BKX987770U',  '336336027425', 'paseo con la novia', 2);
INSERT INTO dancarltondb.reserva VALUES (default, '4LGD28', TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_INIT, @MAX_INIT)), @MIN_INIT), TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_END, @MAX_END)), @MIN_END), 'Emmanuel Ariza', 'S', 'SYY163731D',  '030082436391', 'Viaje de diversion', 1);
INSERT INTO dancarltondb.reserva VALUES (default, 'KHRQ89', TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_INIT, @MAX_INIT)), @MIN_INIT), TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_END, @MAX_END)), @MIN_END), 'Carlos Varderrama', 'N', '',  '404108501020', 'Luna de miel', 3);
INSERT INTO dancarltondb.reserva VALUES (default, 'URRBC4', TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_INIT, @MAX_INIT)), @MIN_INIT), TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_END, @MAX_END)), @MIN_END), 'Donald Trump', 'S', 'HRM822346L',  '112604577431', 'Luna de miel con todos los gastos pagos', 3);
INSERT INTO dancarltondb.reserva VALUES (default, 'DTUGGM', TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_INIT, @MAX_INIT)), @MIN_INIT), TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_END, @MAX_END)), @MIN_END), 'Faustino Asprilla', 'N', '',  '439897216953', 'Viaje de placer recien casados tienen descuento en bar', 3);
INSERT INTO dancarltondb.reserva VALUES (default, 'ABB24S', TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_INIT, @MAX_INIT)), @MIN_INIT), TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_END, @MAX_END)), @MIN_END), 'Maria Goya', 'N', '',  '481621344904', 'Viaje de diversion a ver el partido barcelona vs real madrid', 2);
INSERT INTO dancarltondb.reserva VALUES (default, 'B3SBPS', TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_INIT, @MAX_INIT)), @MIN_INIT), TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_END, @MAX_END)), @MIN_END), 'Rodrigo Rodriguez', 'S', 'III283063L',  '287617978394', 'Viaje de diversion', 1);
INSERT INTO dancarltondb.reserva VALUES (default, 'MJWXD3', TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_INIT, @MAX_INIT)), @MIN_INIT), TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_END, @MAX_END)), @MIN_END), 'Samuel Vigniolo', 'S', 'SQV649133L',  '156667239073', 'Viaje de diversion', 1);
INSERT INTO dancarltondb.reserva VALUES (default, 'GAHVFJ', TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_INIT, @MAX_INIT)), @MIN_INIT), TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_END, @MAX_END)), @MIN_END), 'Karina Paola Luque', 'S', 'UER850502P',  '378744280208', 'Viaje de diversion', 1);
INSERT INTO dancarltondb.reserva VALUES (default, '6EG7YG', TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_INIT, @MAX_INIT)), @MIN_INIT), TIMESTAMPADD(SECOND, FLOOR(RAND() * TIMESTAMPDIFF(SECOND, @MIN_END, @MAX_END)), @MIN_END), 'Juan Manuel Castro', 'S', 'LWB472439P',  '409485659543', 'Viaje de campamento', 2);