CREATE TABLE Clientes(
	nombre VARCHAR(100) PRIMARY KEY,
	telefono INTEGER NOT NULL,
	direccion VARCHAR(100) NOT NULL,
	BaguettesCompradas INTEGER default 0,
	ConsumoAcumulado INTEGER default 0
);

INSERT INTO Clientes VALUES("Ivan Garcia", 12345678, "holaaaa")

SELECT * FROM Clientes;