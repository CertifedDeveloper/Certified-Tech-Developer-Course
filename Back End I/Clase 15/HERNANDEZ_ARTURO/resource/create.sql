CREATE TABLE IF NOT EXISTS  DIRECCIONES (ID INT AUTO_INCREMENT PRIMARY KEY,CALLE VARCHAR(100), NUMERO INT, LOCALIDAD VARCHAR(100), PROVINCIA VARCHAR(100));
CREATE TABLE IF NOT EXISTS  PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100), APELLIDO VARCHAR(100), DNI VARCHAR(15), FECHAINGRESO DATE, ID_DOMICILIO INT);
