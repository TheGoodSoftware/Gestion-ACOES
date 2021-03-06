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
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (1000, 'Juan', 'Garcia', 'Calle Cersh N3', 'Calatchka');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (1001, 'Jose Angel', 'Beltran', 'Colegio Vicente Shrot 8', 'Fritch');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (473829, 'Carlos', 'Perez', 'Calle Cersh N3', 'Calatchka');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (43644984, 'Pedro', 'Mora', 'Calle Almendro 8', 'Cuenca');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (43644985, 'Juan', 'Ruiz', 'Calle Escorial 7', 'Madrid');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (43644986, 'Marcos', 'Pedraza', 'Avenida España 7', 'Malaga');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (43644987, 'Cristian', 'Parra', 'Calle Bergamin 6', 'Malaga');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (43644988, 'Benito', 'Jimenez', 'Calle Fuentes 8', 'Malaga');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (43644989, 'Manuel', 'Johnson', 'Calle Arsh 8', 'Colombia');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (5000, 'Antonio', 'Parsh', 'Avenida España 7', 'Malaga');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (5001, 'Alberto', 'Dieguez', 'Avenida Greo 7', 'Hocrao');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (5002, 'Victor', 'Del Bosque', 'Paseo del Topacio 9', 'Bermuda');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (5003, 'Vicente', 'Johnson', 'Paseo del Burgo', 'Anikse');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (5004, 'Jeremias', 'Jacobo', 'Plaza Augusta', 'Huesca');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (5005, 'Escrondo', 'Gonzalez', 'Avenida Caucaso', 'Pancrsh');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (5006, 'Diego', 'Flight', 'Calle Poncio', 'Kerecho');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (5007, 'Pablo', 'Portesh', 'Calle Escondida', 'Peritxo');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (5008, 'Garlo', 'Bosch', 'Calle A Veces', 'Saplukt');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (5009, 'Vladislavio', 'Gutierrez', 'Calle Vida', 'Leory');
INSERT INTO mydb.persona (idPersona, Nombre, Apellidos, Direccion, Pueblo) VALUES (5010, 'Volash', 'Raymond', 'Avenida Krearsh', 'Vilch');


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
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (473829, '02-04-2002', 101, 'V','22-02-2015', '20-06-2016','21-06-2016', 'Chico tranquilo y buen estudiante','67584744P');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (43644984, '12-02-2004', 101, 'V','24-02-2015', '20-06-2016','21-06-2016', 'Chico inquieto, necesita tutorías','');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (43644985, '22-12-2003', 101, 'V','22-06-2014', '22-02-2015','01-03-2015', '','45678567B');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (43644989, '22-10-2005', 101, 'V','22-06-2014', '22-02-2015','01-03-2015', 'Va bien','45673567W');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (5000, '11-03-2003', 101, 'V','24-02-2015', '20-06-2016','21-06-2016', 'Chico inquieto','');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (5001, '12-02-2014', 101, 'V','24-02-2015', '20-06-2016','21-06-2016', 'Bebé','');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (5002, '12-02-2004', 101, 'V','24-02-2015', '20-06-2016','21-06-2016', '','');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (5003, '18-02-2004', 101, 'V','24-02-2015', '20-06-2016','21-06-2016', '','');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (5004, '11-02-2004', 101, 'V','24-02-2015', '20-06-2016','21-06-2016', '','');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (5005, '13-02-2004', 101, 'V','24-02-2015', '20-06-2016','21-06-2016', '','');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (5006, '15-02-2004', 101, 'V','24-02-2015', '20-06-2016','21-06-2016', '','');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (5007, '12-05-2004', 101, 'V','24-02-2015', '20-06-2016','21-06-2016', '','');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (5008, '12-07-2004', 101, 'V','24-02-2015', '20-06-2016','21-06-2016', '','');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (5009, '12-09-2004', 101, 'V','24-02-2015', '20-06-2016','21-06-2016', '','');
INSERT INTO mydb.nino (idNen, fechaNacimiento, PROYECTO_idProy, sexo, fechaAlta, fechaAltaACOES, fechaAltaProyecto, observaciones, NIF) VALUES (5010, '12-11-2004', 101, 'V','24-02-2015', '20-06-2016','21-06-2016', '','');

COMMIT;

-- -----------------------------------------------------
-- Data for table mydb.notas
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.notas (idNotasNen, Calificacion, NotaMedia, Curso, Observaciones, nino_idNen) VALUES (1, 9, 6, 'Primero', 'A', 473829);
INSERT INTO mydb.notas (idNotasNen, Calificacion, NotaMedia, Curso, Observaciones, nino_idNen) VALUES (2, 7, 7, 'Segundo', 'A', 473829);
INSERT INTO mydb.notas (idNotasNen, Calificacion, NotaMedia, Curso, Observaciones, nino_idNen) VALUES (3, 10, 8, 'Segundo', 'A',  43644984);
INSERT INTO mydb.notas (idNotasNen, Calificacion, NotaMedia, Curso, Observaciones, nino_idNen) VALUES (4, 4, 9, 'Tercero', 'A', 43644984);
INSERT INTO mydb.notas (idNotasNen, Calificacion, NotaMedia, Curso, Observaciones, nino_idNen) VALUES (5, 4, 9, 'Cuarto', 'A', 43644989);
INSERT INTO mydb.notas (idNotasNen, Calificacion, NotaMedia, Curso, Observaciones, nino_idNen) VALUES (6, 4, 8, 'Cuarto', 'A', 5000);
INSERT INTO mydb.notas (idNotasNen, Calificacion, NotaMedia, Curso, Observaciones, nino_idNen) VALUES (7, 4, 6, 'Tercero', 'A', 5001);
INSERT INTO mydb.notas (idNotasNen, Calificacion, NotaMedia, Curso, Observaciones, nino_idNen) VALUES (8, 3, 5, 'Quinto', 'A', 5002);
INSERT INTO mydb.notas (idNotasNen, Calificacion, NotaMedia, Curso, Observaciones, nino_idNen) VALUES (9, 4, 7, 'Cuarto', 'A', 5003);
INSERT INTO mydb.notas (idNotasNen, Calificacion, NotaMedia, Curso, Observaciones, nino_idNen) VALUES (10, 4, 9, 'Octavo', 'A', 5004);
INSERT INTO mydb.notas (idNotasNen, Calificacion, NotaMedia, Curso, Observaciones, nino_idNen) VALUES (11, 4, 9, 'Cuarto', 'A', 5005);



COMMIT;


-- -----------------------------------------------------
-- Data for table mydb.PERMISO
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.permiso (ID, Descripcion) VALUES (1, 'ADMIN');
INSERT INTO mydb.permiso (ID, Descripcion) VALUES (2, 'USUARIO');
INSERT INTO mydb.permiso (ID, Descripcion) VALUES (3, 'ECONOMIA');
INSERT INTO mydb.permiso (ID, Descripcion) VALUES (4, 'ACADEMICO');
INSERT INTO mydb.permiso (ID, Descripcion) VALUES (5, 'AGENTE');

COMMIT;

-- -----------------------------------------------------
-- Data for table mydb.ROL
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.rol (idRol, Nombre, Pais, Descripcion) VALUES (21, 'ADMIN', 'Espana', 'Todos los permisos');
INSERT INTO mydb.rol (idRol, Nombre, Pais, Descripcion) VALUES (22, 'USUARIO', 'Espana', 'Uso estandar');
INSERT INTO mydb.rol (idRol, Nombre, Pais, Descripcion) VALUES (23, 'ECONOMIA', 'Honduras', 'Economia');
INSERT INTO mydb.rol (idRol, Nombre, Pais, Descripcion) VALUES (24, 'ACADEMICO', 'Honduras', 'Academico');
INSERT INTO mydb.rol (idRol, Nombre, Pais, Descripcion) VALUES (25, 'AGENTE', 'Espana', 'Agente');
COMMIT;


-- -----------------------------------------------------
-- Data for table mydb.USUARIO
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.usuario (idUsuario, Contrasenya, Correo, ASOCIACION_Nombre, ROL_idRol) VALUES (1001, 'contrasenya', 'usuario@correo.es', 'Jose Juan', 22);
INSERT INTO mydb.usuario (idUsuario, Contrasenya, Correo, ASOCIACION_Nombre, ROL_idRol) VALUES (1000, 'admin', 'admin@correo.es', 'Benito Bashet', 21);
INSERT INTO mydb.usuario (idUsuario, Contrasenya, Correo, ASOCIACION_Nombre, ROL_idRol) VALUES (43644986, 'economia', 'economia@correo.es', 'Benito Bashet', 23);
INSERT INTO mydb.usuario (idUsuario, Contrasenya, Correo, ASOCIACION_Nombre, ROL_idRol) VALUES (43644987, 'academico', 'academico@correo.es', 'Benito Bashet', 24);
INSERT INTO mydb.usuario (idUsuario, Contrasenya, Correo, ASOCIACION_Nombre, ROL_idRol) VALUES (43644988, 'agente', 'agente@correo.es', 'Benito Bashet', 25);

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
INSERT INTO mydb.rolesPermisos (PERMISO_ID, ROL_idRol) VALUES (3, 23);
INSERT INTO mydb.rolesPermisos (PERMISO_ID, ROL_idRol) VALUES (4, 24);
INSERT INTO mydb.rolesPermisos (PERMISO_ID, ROL_idRol) VALUES (5, 25);

COMMIT;


-- -----------------------------------------------------
-- Data for table mydb.APADRINAR
-- -----------------------------------------------------
START TRANSACTION;
USE mydb;
INSERT INTO mydb.apadrinar (NINO_idNen, USUARIO_idUsuario) VALUES (473829, 1000);
INSERT INTO mydb.apadrinar (NINO_idNen, USUARIO_idUsuario) VALUES (43644985, 1000);
INSERT INTO mydb.apadrinar (NINO_idNen, USUARIO_idUsuario) VALUES (5000, 1001);
INSERT INTO mydb.apadrinar (NINO_idNen, USUARIO_idUsuario) VALUES (5005, 1001);


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

insert into mydb.paquete(NumSeg, FechaEnvio, FechaRecepcion, Confirmado, Padrino, Nino, Descripcion) values (123, 'hoy', '', 0, 1000, 473829, '');
