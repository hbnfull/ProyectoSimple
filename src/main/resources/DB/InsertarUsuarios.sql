-- DMLGBD
USE `GBD` ;
-- Agregando usuario 

 INSERT INTO `usuarios` (`nombre`,`apellido`,`password`,`correo`,`telefono`,`rol`,`foto`) 
VALUES ('Ernesto ','Nieves','holaquehace','ernm@gmail.com',1111111111,'vendedor','foto.jpg');
INSERT INTO `usuarios` (`nombre`,`apellido`,`password`,`correo`,`telefono`,`rol`,`foto`)  
VALUES ('Daniel','Montoya','constra','corre@correo.com',1111111234,'comprador','foto1.jpg');
INSERT INTO `usuarios` (`nombre`,`apellido`,`password`,`correo`,`telefono`,`rol`,`foto`) 
 VALUES ('Adriana', 'Ibarra', 'Pa$$word.1','adimania@gmail.com',1234567890,'vendedor','foto2.jpg');
INSERT INTO `usuarios`(`nombre`,`apellido`,`password`,`correo`,`telefono`,`rol`,`foto`) 
 VALUES ('juan pablo','avina araiza','C@rton54','chito.pepsi@gmail.com',222222222,'comprador','foto3.jpg');
INSERT INTO `usuarios`(`nombre`,`apellido`,`password`,`correo`,`telefono`,`rol`,`foto`) 
 VALUES ('Alberto ','Trejo','C@rton54','albrt@gmail.com',222222222,'comprador','foto4.jpg');


SELECT * FROM GDB.usuarios;
