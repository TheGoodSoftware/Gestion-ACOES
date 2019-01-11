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
INSERT INTO mydb.gestionEconomica (idBalance, balanceTotal) VALUES (114445, -3500);
INSERT INTO mydb.gestionEconomica (idBalance, balanceTotal) VALUES (3232435, 2400);

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
INSERT INTO mydb.nino (idNen, Edad, PROYECTO_idProy) VALUES (473829, 9, 101);
INSERT INTO mydb.nino (idNen, Edad, PROYECTO_idProy) VALUES (43644984, 10, 101);

COMMIT;

-- -----------------------------------------------------
-- Data for table mydb.notas
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.notas (idNotasNen, Calificacion, Curso, nino_idNen) VALUES (1, 9, 'Primero', 473829);
INSERT INTO mydb.notas (idNotasNen, Calificacion, Curso, nino_idNen) VALUES (2, 7, 'Segundo', 473829);
INSERT INTO mydb.notas (idNotasNen, Calificacion, Curso, nino_idNen) VALUES (3, 10, 'Segundo', 43644984);
INSERT INTO mydb.notas (idNotasNen, Calificacion, Curso, nino_idNen) VALUES (4, 4, 'Tercero', 43644984);


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
INSERT INTO mydb.responsableDe (USUARIO_idUsuario, PROYECTO_idProy) VALUES (1000, 101);

COMMIT;


-- -----------------------------------------------------
-- Data for table mydb.RolesPermisos
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.rolesPermisos (PERMISO_ID, ROL_idRol) VALUES (1, 21);
INSERT INTO mydb.rolesPermisos (PERMISO_ID, ROL_idRol) VALUES (2, 22);

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
INSERT INTO mydb.objeto (idObjeto, Descripcion, Pais, Localizacion, CONTENEDOR_idCont, USUARIO_idUsuario) VALUES (26484, 'Objeto2', 'Honduras', 'Jret', 12345, 1000);

COMMIT;

-- -----------------------------------------------------
-- Data for table mydb.DONACION
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.donacion (idDon, Descripcion, Cantidad, Moneda, GESTIONECONOMICA_idBalance, ProcedenciaBeneficiario, Fecha) VALUES (103, 'Donacion Mensual ACOES Malaga', 300, 'Euro', 114445, 'ACOES Malaga', '21/12/2018');
INSERT INTO mydb.donacion (idDon, Descripcion, Cantidad, Moneda, GESTIONECONOMICA_idBalance, ProcedenciaBeneficiario, Fecha) VALUES (204, 'Donacion Extra ACOES Madrid', 1500, 'Lempira', 3232435, 'ACOES Madrid', '23/12/2018');
INSERT INTO mydb.donacion (idDon, Descripcion, Cantidad, Moneda, GESTIONECONOMICA_idBalance, ProcedenciaBeneficiario, Fecha) VALUES (300, 'Donacion Mensual ACOES Leon', 500, 'Euro', 114445, 'ACOES Malaga', '01/01/2019');
INSERT INTO mydb.donacion (idDon, Descripcion, Cantidad, Moneda, GESTIONECONOMICA_idBalance, ProcedenciaBeneficiario, Fecha) VALUES (415, 'Donacion Mensual ACOES Barcelona', 1500, 'Euro', 114445, 'ACOES Malaga', '03/01/2019');
INSERT INTO mydb.donacion (idDon, Descripcion, Cantidad, Moneda, GESTIONECONOMICA_idBalance, ProcedenciaBeneficiario, Fecha) VALUES (005, 'Donacion Mensual ACOES Madrid', 300, 'Euro', 114445, 'Donacion ACOES Malaga', '11/01/2019');
INSERT INTO mydb.donacion (idDon, Descripcion, Cantidad, Moneda, GESTIONECONOMICA_idBalance, ProcedenciaBeneficiario, Fecha) VALUES (026, 'Cuotas apadrinamientos ACOES Malaga', 400, 'Euro', 114445, 'ACOES Malaga', '15/01/2019');


COMMIT;


-- -----------------------------------------------------
-- Data for table mydb.GASTO
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.gasto (idGasto, Cantidad, Moneda, Descripcion, GESTIONECONOMICA_idBalance, Fecha, ProcedenciaBeneficiario) VALUES (1000, 1100, 'Lempira', 'Material escolar', 114445, '27/12/2018', 'CCJ San Miguel');
INSERT INTO mydb.gasto (idGasto, Cantidad, Moneda, Descripcion, GESTIONECONOMICA_idBalance, Fecha, ProcedenciaBeneficiario) VALUES (1001, 500, 'Euro', 'Material escolar', 114445, '15/01/2019', 'CCJ San Marcos');
INSERT INTO mydb.gasto (idGasto, Cantidad, Moneda, Descripcion, GESTIONECONOMICA_idBalance, Fecha, ProcedenciaBeneficiario) VALUES (903, 1500, 'Lempira', 'Comida desayunos', 114445, '20/01/2019', 'CCJ San Marcos');
INSERT INTO mydb.gasto (idGasto, Cantidad, Moneda, Descripcion, GESTIONECONOMICA_idBalance, Fecha, ProcedenciaBeneficiario) VALUES (1054, 1700, 'Lempira', 'Gasolina', 114445, '21/01/2019', 'Casa Populorum Montaña');

COMMIT;
