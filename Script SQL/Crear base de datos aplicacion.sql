DROP DATABASE IF EXISTS aplicacion;
CREATE DATABASE aplicacion;

CREATE TABLE "tipoAtraccion" (
	"idTipo"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL UNIQUE,
	PRIMARY KEY("idTipo" AUTOINCREMENT)
);

CREATE TABLE "atraccion" (
	"idAtraccion"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL UNIQUE,
	"tiempo"	INTEGER NOT NULL,
	"costo"	REAL NOT NULL,
	"cupo"	INTEGER NOT NULL,
	"id_tipo"	INTEGER NOT NULL,
	PRIMARY KEY("idAtraccion" AUTOINCREMENT),
	FOREIGN KEY("id_tipo") REFERENCES "tipoAtraccion"("idTipo")
);

CREATE TABLE "promocion" (
	"idPromocion"	INTEGER NOT NULL UNIQUE,
	"tiempo"	INTEGER NOT NULL,
	"costo"	INTEGER NOT NULL,
	"atracciones"	TEXT NOT NULL,
	"id_tipo"	INTEGER,
	FOREIGN KEY("id_tipo") REFERENCES "tipoAtraccion"("idTipo"),
	PRIMARY KEY("idPromocion" AUTOINCREMENT)
);

CREATE TABLE "usuario" (
	"idUsuario"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL UNIQUE,
	"monedas"	INTEGER NOT NULL,
	"tiempo"	INTEGER NOT NULL,
	"id_tipo"	INTEGER NOT NULL,
	PRIMARY KEY("idUsuario" AUTOINCREMENT),
	FOREIGN KEY("id_tipo") REFERENCES "tipoAtraccion"("idTipo")
);

CREATE TABLE "itinerario" (
	"idItinerario"	INTEGER NOT NULL UNIQUE,
	"listaAtracciones"	INTEGER,
	"listaPromociones"	INTEGER,
	"tiempo total"	INTEGER,
	"costo total"	INTEGER,
	"id_usuario"	INTEGER NOT NULL UNIQUE,
	FOREIGN KEY("id_usuario") REFERENCES "usuario"("idUsuario"),
	PRIMARY KEY("idItinerario" AUTOINCREMENT)
);

INSERT INTO tipoAtraccion VALUES (1, "Aventura");
INSERT INTO tipoAtraccion VALUES (2, "Paisaje");
INSERT INTO tipoAtraccion VALUES (3, "Degustacion");

INSERT INTO atraccion VALUES (1, "Moria", 2, 10, 6, 1);
INSERT INTO atraccion VALUES (2, "Minas Tirith", 2.5, 5, 25, 2);
INSERT INTO atraccion VALUES (3, "La Comarca", 6.5, 3.0, 150, 3);
INSERT INTO atraccion VALUES (4, "Mordor", 3, 25.0, 4, 1);
INSERT INTO atraccion VALUES (5, "Abismo de Helm", 2, 5.0, 15, 2);
INSERT INTO atraccion VALUES (6, "Lothlórien", 1, 35.0, 30, 3);
INSERT INTO atraccion VALUES (7, "Erebor", 3, 12.0, 32, 2);
INSERT INTO atraccion VALUES (8, "Bosque Negro", 4, 3.0, 12, 1);

INSERT INTO usuario VALUES (1, "Eowyn", 10, 8, 1);
INSERT INTO usuario VALUES (2, "Gandalf", 100, 5, 2);
INSERT INTO usuario VALUES (3, "Sam", 36, 8, 3);
INSERT INTO usuario VALUES (4, "Galadriel", 120, 3, 2);


