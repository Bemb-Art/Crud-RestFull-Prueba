# crud
el servidor de la base de datos es expuesto en el puerto 3307 cambiar por el puerto de su servidor en la propiedad application.properties
uso de jdk 15.02
version de spring 2.7.16
version de Mysql 8.0.34.0
querys SQL 

CREATE DATABASE prueba_byte;
USE prueba_byte;
CREATE SCHEMA empresa_db;
USE empresa_db;

CREATE TABLE empresa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    nit VARCHAR(50) NOT NULL UNIQUE,
    fechaFundacion DATE NOT NULL,
    direccion VARCHAR(255) NOT NULL
);

INSERT INTO empresa (nombre, nit, fechaFundacion, direccion)
VALUES ('Empresa A', '123456-7', '2020-01-15', 'Calle 123, Ciudad A');
INSERT INTO empresa (nombre, nit, fechaFundacion, direccion)
VALUES ('Empresa B', '987654-3', '2015-06-20', 'Avenida 456, Ciudad B');

INSERT INTO empresa (nombre, nit, fechaFundacion, direccion)
VALUES ('Empresa C', '567890-1', '2010-11-10', 'Carrera 789, Ciudad C');

Url: 
get http://localhost:4567/empresa
post http://localhost:4567/createEmpresa/
put http://localhost:4567/updateEmpresa/:id
delete http://localhost:4567/delete/:id
