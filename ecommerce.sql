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





CREATE USER javier IDENTIFIED BY 'javier';
GRANT ALL PRIVILEGES ON ecommerce.* to javier;




