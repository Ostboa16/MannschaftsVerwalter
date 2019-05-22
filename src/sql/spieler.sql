DROP TABLE Spieler; --IF EXITS

DROP TABLE Spieler IF EXISTS;


CREATE TABLE Spieler
(
name VARCHAR(255),
rueckennummer INTEGER,
position VARCHAR(255),
PRIMARY KEY(rueckennummer)
);

--mit Auto Key
INSERT INTO Spieler(name, rueckennummer, position)
       VALUES ('[K] Boris Ostojic',7,'Stürmer');

Delete FROM Spieler where rueckennummer=7;
DELETE FROM Spieler;

UPDATE Spieler  SET name='Boris Osto', rueckennummer=77 WHERE rueckennummer = 7;


Select * from Spieler;
