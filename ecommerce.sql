CREATE DATABASE ecommerce;

USE ecommerce;

CREATE TABLE Usuarios (
  id_usuario INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE Roles (
  id_rol INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL
);

CREATE TABLE Usuarios_Roles (
  id_usuario INT,
  id_rol INT,
  PRIMARY KEY(id_usuario, id_rol),
  FOREIGN KEY(id_usuario) REFERENCES Usuarios(id_usuario),
  FOREIGN KEY(id_rol) REFERENCES Roles(id_rol)
);

CREATE TABLE Direcciones (
  id_direccion INT AUTO_INCREMENT PRIMARY KEY,
  codigo_postal VARCHAR(5) NOT NULL,
  localidad VARCHAR(100) NOT NULL,
  calle VARCHAR(100) NOT NULL,
  numero INT NOT NULL,
  piso VARCHAR(5),
  letra VARCHAR(5)
);

CREATE TABLE usuarios_direcciones (
    id_usuario INT NOT NULL,
    id_direccion INT NOT NULL,
    PRIMARY KEY (id_usuario, id_direccion),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_direccion) REFERENCES direcciones(id_direccion)
);


CREATE TABLE Tarjetas (
  id_tarjeta INT AUTO_INCREMENT PRIMARY KEY,
  num_tarjeta VARCHAR(16) UNIQUE NOT NULL,
  nombre_titular VARCHAR(100) NOT NULL,
  fecha_caducidad DATE NOT NULL,
  CVV INT NOT NULL
);

CREATE TABLE Usuarios_Tarjetas (
  id_usuario INT,
  id_tarjeta INT,
  PRIMARY KEY(id_usuario, id_tarjeta),
  FOREIGN KEY(id_usuario) REFERENCES Usuarios(id_usuario),
  FOREIGN KEY(id_tarjeta) REFERENCES Tarjetas(id_tarjeta)
);

CREATE TABLE Productos (
  id_producto INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  descripcion TEXT NOT NULL,
  precio DECIMAL(10, 2) NOT NULL,
  stock INT NOT NULL
);

CREATE TABLE Pedidos (
  id_pedido INT AUTO_INCREMENT PRIMARY KEY,
  fecha DATETIME NOT NULL,
  id_direccion INT,
  id_tarjeta INT,
  FOREIGN KEY(id_direccion) REFERENCES Direcciones(id_direccion),
  FOREIGN KEY(id_tarjeta) REFERENCES Tarjetas(id_tarjeta)
);

CREATE TABLE Pedidos_Productos (
  id_pedido INT,
  id_producto INT,
  unidades INT NOT NULL,
  precio_venta DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY(id_pedido, id_producto),
  FOREIGN KEY(id_pedido) REFERENCES Pedidos(id_pedido),
  FOREIGN KEY(id_producto) REFERENCES Productos(id_producto)
);


INSERT INTO Usuarios (nombre, apellidos, fecha_nacimiento, email, password) VALUES
('Juan', 'Perez Garcia', '1990-05-20', 'juan.perez@mail.com', 'juan'),
('Maria', 'Lopez Fernandez', '1988-03-12', 'maria.lopez@mail.com', 'maria'),
('Pedro', 'Gonzalez Rodriguez', '1995-07-01', 'pedro.gonzalez@mail.com', 'pedro'),
('Laura', 'Martinez Perez', '1992-09-05', 'laura.martinez@mail.com', 'laura'),
('Carlos', 'Sanchez Gomez', '1997-02-14', 'carlos.sanchez@mail.com', 'carlos'),
('Ana', 'Garcia Lopez', '1991-11-23', 'ana.garcia@mail.com', 'ana'),
('David', 'Fernandez Sanchez', '1993-06-09', 'david.fernandez@mail.com', 'david'),
('Carmen', 'Rodriguez Martin', '1989-12-30', 'carmen.rodriguez@mail.com', 'carmen'),
('Javier', 'Gomez Jimenez', '1996-08-18', 'javier.gomez@mail.com', 'javier'),
('Sara', 'Perez Sanchez', '1994-04-07', 'sara.perez@mail.com', 'sara');

select * from usuarios;

INSERT INTO Roles (nombre) VALUES 
('rol_cliente'), 
('rol_admin');

select * from roles;

INSERT INTO Usuarios_Roles (id_usuario, id_rol) VALUES
    (1, 2), -- Juan es administrador
    (2, 1), -- Cliente 1
    (3, 1), -- Cliente 2
    (4, 1), -- Cliente 3
    (5, 1), -- Cliente 4
    (6, 1), -- Cliente 5
    (7, 1), -- Cliente 6
    (8, 1), -- Cliente 7
    (9, 1), -- Cliente 8
    (10, 1); -- Cliente 9
    
select * from usuarios_roles;

INSERT INTO Direcciones (codigo_postal, localidad, calle, numero, piso, letra) VALUES
('28001', 'Madrid', 'Calle de Atocha', 1, '1r', NULL),
('28001', 'Madrid', 'Gran V??a', 123, '3r', '1a'),
('28001', 'Madrid', 'Calle de Alcal??', 100, '2o', 'B'),
('28002', 'Madrid', 'Calle de Serrano', 50, '4o', 'D'),
('46001', 'Valencia', 'Plaza del Ayuntamiento', 1, '1o', 'A'),
('46002', 'Valencia', 'Calle de Col??n', 50, '5o', 'C'),
('41001', 'Sevilla', 'Calle Sierpes', 1, '2o', 'A'),
('41002', 'Sevilla', 'Avenida de la Constituci??n', 1, '1o', 'C'),
('50001', 'Zaragoza', 'Paseo Independencia', 24, '3o', 'B'),
('50002', 'Zaragoza', 'Calle de Don Jaime I', 18, '1o', 'D');

select * from direcciones;

INSERT INTO usuarios_direcciones (id_usuario, id_direccion) VALUES
  (1, 2),
  (2, 4),
  (3, 10),
  (4, 6),
  (5, 8),
  (6, 1),
  (7, 3),
  (8, 5),
  (9, 7),
  (10, 9);
  
  select * from usuarios_direcciones;
  
  INSERT INTO Tarjetas (num_tarjeta, nombre_titular, fecha_caducidad, CVV) VALUES 
('1111222233334444', 'Juan Perez', '2024-05-01', 123),
('2222333344445555', 'Maria Garcia', '2023-11-01', 456),
('3333444455556666', 'Pedro Fernandez', '2024-02-01', 789),
('4444555566667777', 'Sofia Rodriguez', '2025-08-01', 234),
('5555666677778888', 'Lucas Martinez', '2022-10-01', 567),
('6666777788889999', 'Elena Sanchez', '2023-12-01', 890),
('7777888899990000', 'Carlos Gomez', '2026-01-01', 345),
('8888999900001111', 'Ana Torres', '2022-06-01', 678),
('9999000011112222', 'Javier Jimenez', '2025-03-01', 901),
('0000111122223333', 'Laura Navarro', '2024-09-01', 234);

select * from tarjetas;

INSERT INTO Usuarios_Tarjetas (id_usuario, id_tarjeta) VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10);

select * from usuarios_tarjetas;

INSERT INTO Productos (id_producto, nombre, descripcion, precio, stock) VALUES 
       (100, 'Nike Air Force', 'Zapatillas cl??sicas de Nike', 89.99, 15),
       (110, 'Adidas Superstar', 'Zapatillas de la l??nea Originals de Adidas', 79.99, 12),
       (120, 'Puma Suede Classic', 'Zapatillas ic??nicas de Puma', 69.99, 17),
       (130, 'Reebok Classic', 'Zapatillas de la l??nea Classics de Reebok', 59.99, 11),
       (140, 'New Balance 574', 'Zapatillas de estilo retro de New Balance', 79.99, 16),
       (150, 'Converse Chuck Taylor All Star', 'Zapatillas de lona de Converse', 64.99, 13),
       (160, 'Vans Old Skool', 'Zapatillas cl??sicas de Vans', 69.99, 14),
       (170, 'Asics Gel-Kayano 27', 'Zapatillas de running de Asics', 129.99, 18),
       (180, 'Under Armour HOVR Phantom', 'Zapatillas de running de Under Armour', 109.99, 20),
       (190, 'Salomon Speedcross 5', 'Zapatillas de trail running de Salomon', 139.99, 19),
       (200, 'Brooks Ghost 13', 'Zapatillas de running de Brooks', 119.99, 16),
       (210, 'Mizuno Wave Rider 24', 'Zapatillas de running de Mizuno', 99.99, 15),
       (220, 'Hoka One One Clifton 7', 'Zapatillas de running de Hoka One One', 149.99, 18),
       (230, 'Saucony Kinvara 12', 'Zapatillas de running de Saucony', 89.99, 12),
       (240, 'On Cloud X', 'Zapatillas de running de On', 129.99, 17),
       (250, 'Asics Gel-Nimbus 23', 'Zapatillas de running de Asics', 149.99, 20),
       (260, 'Nike Air Max 90', 'Zapatillas ic??nicas de Nike', 119.99, 19),
       (270, 'Adidas Ultraboost 21', 'Zapatillas de running de Adidas', 179.99, 14),
       (280, 'Puma Calibrate Runner', 'Zapatillas de running de Puma', 99.99, 15),
       (290, 'Reebok Zig Kinetica', 'Zapatillas de running de Reebok', 109.99, 16);
       
       select * from productos;
       

  
  INSERT INTO Pedidos (id_pedido, fecha, id_direccion, id_tarjeta) VALUES 
(1000, '2023-01-01 10:20:16', 1, 1),
(1010, '2023-01-02 11:05:46', 2, 2),
(1020,'2023-01-03 12:20:01', 3, 3),
(1030,'2023-01-04 13:45:00', 4, 4),
(1040, '2023-01-05 14:27:09', 5, 5),
(1050, '2023-01-10 15:27:09', 6, 6),
(1060, '2023-01-10 16:27:09', 7, 7),
(1070, '2023-01-11 17:27:09', 8, 8),
(1080, '2023-01-11 18:27:09', 9, 9),
(1090, '2023-01-12 19:27:09', 10, 10);

select * from pedidos;

INSERT INTO Pedidos_Productos (id_pedido, id_producto, unidades, precio_venta) VALUES 
(1000, 100, 2, 179.98),
(1010, 120, 1, 69.99),
(1020, 200, 1, 119.99),
(1030, 140, 2, 159.98),
(1040, 160, 1, 69.99),
(1050, 110, 1, 79.99),
(1060, 100, 1, 89.99),
(1070, 150, 1, 64.99),
(1080, 220, 1, 149.99),
(1090, 280, 1, 99.99);

ALTER TABLE Pedidos_Productos ADD CONSTRAINT fk_pedidos_productos_pedidos FOREIGN KEY (id_pedido) REFERENCES Pedidos(id_pedido);
ALTER TABLE Pedidos_Productos ADD CONSTRAINT fk_pedidos_productos_productos FOREIGN KEY (id_producto) REFERENCES Productos(id_producto);

select * from pedidos_productos;


CREATE USER javier IDENTIFIED BY 'javier';
GRANT ALL PRIVILEGES ON ecommerce.* to javier;




