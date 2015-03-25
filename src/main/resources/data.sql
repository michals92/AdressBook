CREATE TABLE contacts (id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, firstName VARCHAR(30), surName VARCHAR(30), address VARCHAR(80), phoneNumber VARCHAR(20), mail VARCHAR(50), born DATE);
INSERT INTO contacts (firstName, surName, address, phoneNumber, mail, born) VALUES ('Michal','Simik','Nad Vyvozem 4850 Zlin','731890795','michal.simik@centrum.cz',DATE('1992-10-1'));
