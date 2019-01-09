-- -----------------------------------------------------
-- Data for table mydb.ASOCIACION
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.asociacion (Nombre, Localizacion) VALUES ('Jose Juan', 'Fritch');
INSERT INTO mydb.asociacion (Nombre, Localizacion) VALUES ('Benito Bashet', 'Durengo');

COMMIT;

-- -----------------------------------------------------
-- Data for table mydb.GestionEconomica
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.gestioneconomica (idBalance, balanceTotal) VALUES (114445, -3500);
INSERT INTO mydb.gestioneconomica (idBalance, balanceTotal) VALUES (3232435, 2400);

COMMIT;

-- -----------------------------------------------------
-- Data for table mydb.PERSONA
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (1000, 'Francisco', 'Jonasio', 'Calle Cersh N3', 'Calatchka');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (1001, 'Dimitri', 'Vetrov', 'Colegio Vicente Shrot', 'Fritch');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (473829, 'Carlos', 'Carle', 'Calle Cersh N3', 'Calatchka');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (43644984, 'Pedro', 'Mora', 'Colegio Vicente Shrot', 'Fritch');


COMMIT;

-- -----------------------------------------------------
-- Data for table mydb.PROYECTO
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.proyecto (idProy, tipoProy, refPais, Descripcion, Localizacion, Acabado) VALUES (100, 'CCJ', 'Honduras', 'CCJ Alberto Shret', 'Chikret', 1);
INSERT INTO mydb.proyecto (idProy, tipoProy, refPais, Descripcion, Localizacion, Acabado) VALUES (101, 'CasaPopulorum', 'Honduras', 'CP Bonifracio Shish', 'Karat', 0);

COMMIT;

-- -----------------------------------------------------
-- Data for table mydb.NINO
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.nino (idNen, Edad, Notas, PROYECTO_idProy) VALUES (473829, 9, '8', 101);
INSERT INTO mydb.nino (idNen, Edad, Notas, PROYECTO_idProy) VALUES (43644984, 10, '3', 101);

COMMIT;


-- -----------------------------------------------------
-- Data for table mydb.PERMISO
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.permiso (ID, Descripcion) VALUES (1, 'ADMIN');
INSERT INTO mydb.permiso (ID, Descripcion) VALUES (2, 'USUARIO');

COMMIT;

-- -----------------------------------------------------
-- Data for table mydb.ROL
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.rol (idRol, Nombre, Pais, Descripcion) VALUES (21, 'ADMIN', 'Espana', 'Todos los permisos');
INSERT INTO mydb.rol (idRol, Nombre, Pais, Descripcion) VALUES (22, 'USUARIO', 'Espana', 'Uso estandar');

COMMIT;


-- -----------------------------------------------------
-- Data for table mydb.USUARIO
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.usuario (idUsuario, Contrasenya, Correo, ASOCIACION_Nombre, ROL_idRol) VALUES (1001, 'contrasenya', 'usuario@correo.es', 'Jose Juan', 22);
INSERT INTO mydb.usuario (idUsuario, Contrasenya, Correo, ASOCIACION_Nombre, ROL_idRol) VALUES (1000, 'admin', 'admin@correo.es', 'Benito Bashet', 21);

COMMIT;

-- -----------------------------------------------------
-- Data for table mydb.ResponsableDe
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.responsablede (USUARIO_idUsuario, PROYECTO_idProy) VALUES (1000, 101);

COMMIT;


-- -----------------------------------------------------
-- Data for table mydb.RolesPermisos
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.rolespermisos (PERMISO_ID, ROL_idRol) VALUES (1, 21);
INSERT INTO mydb.rolespermisos (PERMISO_ID, ROL_idRol) VALUES (2, 22);

COMMIT;


-- -----------------------------------------------------
-- Data for table mydb.APADRINAR
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.apadrinar (NINO_idNen, USUARIO_idUsuario) VALUES (473829, 1000);

COMMIT;


-- -----------------------------------------------------
-- Data for table mydb.CONTENEDOR
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.contenedor (idCont, paisActual, Enviado, USUARIO_idUsuario) VALUES (12345, 'Espana', 0, 1001);

COMMIT;

-- -----------------------------------------------------
-- Data for table mydb.OBJETO
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.objeto (idObjeto, Descripcion, Pais, Localizacion, CONTENEDOR_idCont, USUARIO_idUsuario) VALUES (26332, 'Objeto1', 'Espana', 'Antequera', 12345, 1001);
INSERT INTO mydb.objecto (idObjeto, Descripcion, Pais, Localizacion, CONTENEDOR_idCont, USUARIO_idUsuario) VALUES (26484, 'Objeto2', 'Honduras', 'Jret', 5423, 1000);

COMMIT;

-- -----------------------------------------------------
-- Data for table mydb.DONACION
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.donacion (idDon, Descripcion, Cantidad, Moneda, GESTIONECONOMICA_idBalance, USUARIO_idUsuario) VALUES (3333, 'Donante habitual', 300, 'Euro', 114445, 1001);
INSERT INTO mydb.donacion (idDon, Descripcion, Cantidad, Moneda, GESTIONECONOMICA_idBalance, USUARIO_idUsuario) VALUES (3214, 'Donante2', 1500, 'Lempira', 3232435, 1000);

COMMIT;


-- -----------------------------------------------------
-- Data for table mydb.GASTO
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.gasto (idGasto, Cantidad, Moneda, Descripcion, GESTIONECONOMICA_idBalance, USUARIO_idUsuario) VALUES (7859, 2300, 'Euro', 'Evento1', 114445, 1001);
INSERT INTO mydb.gasto (idGasto, Cantidad, Moneda, Descripcion, GESTIONECONOMICA_idBalance, USUARIO_idUsuario) VALUES (36274, 1100, 'Lempira', 'MaterialesDiego', 3232435, 1000);

COMMIT;
