-- Crear la tabla monitor
CREATE TABLE monitor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    phoneNumber VARCHAR(20),
    bornDate DATE,
    address VARCHAR(255),
    email VARCHAR(255)
);

-- Crear la tabla instructor
CREATE TABLE instructor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    phoneNumber VARCHAR(20),
    bornDate DATE,
    address VARCHAR(255),
    email VARCHAR(255)
);

-- Insertar 5 monitores
INSERT INTO monitor (name, phoneNumber, bornDate, address, email) VALUES
('Monitor 1', '123456789', '1990-01-01', 'Dirección 1', 'monitor1@example.com'),
('Monitor 2', '987654321', '1991-02-02', 'Dirección 2', 'monitor2@example.com'),
('Monitor 3', '456789123', '1992-03-03', 'Dirección 3', 'monitor3@example.com'),
('Monitor 4', '321654987', '1993-04-04', 'Dirección 4', 'monitor4@example.com'),
('Monitor 5', '789123456', '1994-05-05', 'Dirección 5', 'monitor5@example.com');



-- Insertar 5 instrutores
INSERT INTO instructor (name, phoneNumber, bornDate, address, email) VALUES
('Instructor 1', '123456789', '1990-01-01', 'Dirección 1', 'instructor1@example.com'),
('Instructor 2', '987654321', '1991-02-02', 'Dirección 2', 'instructor2@example.com'),
('Instructor 3', '456789123', '1992-03-03', 'Dirección 3', 'instructor3@example.com'),
('Instructor 4', '321654987', '1993-04-04', 'Dirección 4', 'instructor4@example.com'),
('Instructor 5', '789123456', '1994-05-05', 'Dirección 5', 'instructor5@example.com');