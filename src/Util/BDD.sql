/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  sebas
 * Created: 15 jul. 2023
 */

--Esta en MySQL--
DROP DATABASE IF EXISTS pizzeria;
CREATE DATABASE pizzeria;
USE pizzeria;

CREATE TABLE Factura (
    cod_pag varchar(30)  NOT NULL,
    fecha date  NOT NULL,
    pago_total decimal(5,2)  NOT NULL,
    Metodo_Pago_cod_met int  NOT NULL,
    Orden_cod_orden int  NOT NULL,
    CONSTRAINT Factura_pk PRIMARY KEY  (cod_pag)
);

-- Table: Metodo_Pago
CREATE TABLE Metodo_Pago (
    cod_met int  NOT NULL,
    tipo_pago int  NOT NULL,
    CONSTRAINT Metodo_Pago_pk PRIMARY KEY  (cod_met)
);

-- Table: Orden
CREATE TABLE Orden (
    cod_orden int  NOT NULL AUTO_INCREMENT,
    Nobre varchar(30)  NOT NULL,
    fecha date  NOT NULL,
    usuario_cod_usu int  NOT NULL,
    CONSTRAINT Orden_pk PRIMARY KEY  (cod_orden)
);

-- Table: Pizza
CREATE TABLE Pizza (
    cod_pizza varchar(30)  NOT NULL,
    detalle varchar(50)  NOT NULL,
    precio decimal(5,2)  NOT NULL,
    pizza_categoria_cod_cate varchar(10)  NOT NULL,
    tamano_cod_Tam int  NOT NULL,
    CONSTRAINT Pizza_pk PRIMARY KEY  (cod_pizza)
);

-- Table: detalle_gaseosa
CREATE TABLE detalle_gaseosa (
    cantidad int  NOT NULL,
    precio decimal(5,2)  NOT NULL,
    Orden_cod_orden int  NOT NULL,
    gaseosa_cod_gaseosa varchar(30)  NOT NULL,
    CONSTRAINT detalle_gaseosa_pk PRIMARY KEY  (Orden_cod_orden,gaseosa_cod_gaseosa)
);

-- Table: detalle_pizza
CREATE TABLE detalle_pizza (
    cantidad int  NOT NULL,
    precio decimal(8,2)  NOT NULL,
    Orden_cod_orden int  NOT NULL,
    Pizza_cod_pizza varchar(30)  NOT NULL,
    CONSTRAINT detalle_pizza_pk PRIMARY KEY  (Orden_cod_orden,Pizza_cod_pizza)
);

-- Table: detalle_promocion
CREATE TABLE detalle_promocion (
    canttidad int  NOT NULL,
    precio decimal(5,2)  NOT NULL,
    Orden_cod_orden int  NOT NULL,
    promocion_pizza_cod_prom varchar(50)  NOT NULL,
    CONSTRAINT detalle_promocion_pk PRIMARY KEY  (Orden_cod_orden,promocion_pizza_cod_prom)
);

-- Table: gaseosa
CREATE TABLE gaseosa (
    cod_gaseosa varchar(30)  NOT NULL,
    marca varchar(30)  NOT NULL,
    tamano varchar(30)  NOT NULL,
    precio decimal(5,2)  NOT NULL,
    descripcion varchar(200)  NOT NULL,
    imagen varchar(100)  NOT NULL,
    CONSTRAINT gaseosa_pk PRIMARY KEY  (cod_gaseosa)
);

-- Table: pizza_categoria
CREATE TABLE pizza_categoria (
    cod_cate varchar(10)  NOT NULL,
    nombre varchar(30)  NOT NULL,
    imagen varchar(50)  NOT NULL,
    descripcion varchar(100)  NOT NULL,
    CONSTRAINT pizza_categoria_pk PRIMARY KEY  (cod_cate)
);

-- Table: promocion_pizza
CREATE TABLE promocion_pizza (
    cod_prom varchar(50)  NOT NULL,
    nombre varchar(50)  NOT NULL,
    cant_pizza int  NOT NULL,
    cantidad_gaseosa int  NOT NULL,
    img varchar(30)  NOT NULL,
    precio decimal(5,2)  NOT NULL,
    Pizza_cod_pizza varchar(30)  NOT NULL,
    gaseosa_cod_gaseosa varchar(30)  NOT NULL,
    CONSTRAINT promocion_pizza_pk PRIMARY KEY  (cod_prom)
);

-- Table: tamano
CREATE TABLE tamano (
    cod_Tam int  NOT NULL,
    nombre varchar(20)  NOT NULL,
    CONSTRAINT tamano_pk PRIMARY KEY  (cod_Tam)
);

-- Table: usuario
CREATE TABLE usuario (
    cod_usu int  NOT NULL AUTO_INCREMENT,
    nombre varchar(100)  NOT NULL,
    correo varchar(100)  NOT NULL,
    contrasena varchar(30)  NOT NULL,
    rol varchar(50)  NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY  (cod_usu)
);

-- foreign keys
-- Reference: Factura_Metodo_Pago (table: Factura)
ALTER TABLE Factura ADD CONSTRAINT Factura_Metodo_Pago
    FOREIGN KEY (Metodo_Pago_cod_met)
    REFERENCES Metodo_Pago (cod_met);

-- Reference: Factura_Orden (table: Factura)
ALTER TABLE Factura ADD CONSTRAINT Factura_Orden
    FOREIGN KEY (Orden_cod_orden)
    REFERENCES Orden (cod_orden);

-- Reference: Orden_usuario (table: Orden)
ALTER TABLE Orden ADD CONSTRAINT Orden_usuario
    FOREIGN KEY (usuario_cod_usu)
    REFERENCES usuario (cod_usu);

-- Reference: Pizza_pizza_categoria (table: Pizza)
ALTER TABLE Pizza ADD CONSTRAINT Pizza_pizza_categoria
    FOREIGN KEY (pizza_categoria_cod_cate)
    REFERENCES pizza_categoria (cod_cate);

-- Reference: Pizza_tamano (table: Pizza)
ALTER TABLE Pizza ADD CONSTRAINT Pizza_tamano
    FOREIGN KEY (tamano_cod_Tam)
    REFERENCES tamano (cod_Tam);

-- Reference: detalle_gaseosa_Orden (table: detalle_gaseosa)
ALTER TABLE detalle_gaseosa ADD CONSTRAINT detalle_gaseosa_Orden
    FOREIGN KEY (Orden_cod_orden)
    REFERENCES Orden (cod_orden);

-- Reference: detalle_gaseosa_gaseosa (table: detalle_gaseosa)
ALTER TABLE detalle_gaseosa ADD CONSTRAINT detalle_gaseosa_gaseosa
    FOREIGN KEY (gaseosa_cod_gaseosa)
    REFERENCES gaseosa (cod_gaseosa);

-- Reference: detalle_pizza_Orden (table: detalle_pizza)
ALTER TABLE detalle_pizza ADD CONSTRAINT detalle_pizza_Orden
    FOREIGN KEY (Orden_cod_orden)
    REFERENCES Orden (cod_orden);

-- Reference: detalle_pizza_Pizza (table: detalle_pizza)
ALTER TABLE detalle_pizza ADD CONSTRAINT detalle_pizza_Pizza
    FOREIGN KEY (Pizza_cod_pizza)
    REFERENCES Pizza (cod_pizza);

-- Reference: detalle_promocion_Orden (table: detalle_promocion)
ALTER TABLE detalle_promocion ADD CONSTRAINT detalle_promocion_Orden
    FOREIGN KEY (Orden_cod_orden)
    REFERENCES Orden (cod_orden);

-- Reference: detalle_promocion_promocion_pizza (table: detalle_promocion)
ALTER TABLE detalle_promocion ADD CONSTRAINT detalle_promocion_promocion_pizza
    FOREIGN KEY (promocion_pizza_cod_prom)
    REFERENCES promocion_pizza (cod_prom);

-- Reference: promocion_pizza_Pizza (table: promocion_pizza)
ALTER TABLE promocion_pizza ADD CONSTRAINT promocion_pizza_Pizza
    FOREIGN KEY (Pizza_cod_pizza)
    REFERENCES Pizza (cod_pizza);

-- Reference: promocion_pizza_gaseosa (table: promocion_pizza)
ALTER TABLE promocion_pizza ADD CONSTRAINT promocion_pizza_gaseosa
    FOREIGN KEY (gaseosa_cod_gaseosa)
    REFERENCES gaseosa (cod_gaseosa);

-- End of file.


---Usuarios
INSERT INTO `usuario` (`cod_usu`, `nombre`, `correo`, `contrasena`, `rol`) VALUES ('1', 'Javier', 'javier32@gmail.com', 'javier', 'administrador');
INSERT INTO `usuario` (`cod_usu`, `nombre`, `correo`, `contrasena`, `rol`) VALUES (NULL, 'Sebastian', 'sebas@gmail.com', 'sabes', 'administrador');
INSERT INTO `usuario` (`cod_usu`, `nombre`, `correo`, `contrasena`, `rol`) VALUES (NULL, 'Jefry', 'jefry09@gmail.com', 'yrfej', 'administrador');
INSERT INTO `usuario` (`cod_usu`, `nombre`, `correo`, `contrasena`, `rol`) VALUES (NULL, 'Derick', 'derick@gmail.com', 'kcired', 'administrador');


-- tamaño
INSERT INTO `tamano` (`cod_Tam`, `nombre`) VALUES ('10001', 'grande');
INSERT INTO `tamano` (`cod_Tam`, `nombre`) VALUES ('10002', 'mediano');
INSERT INTO `tamano` (`cod_Tam`, `nombre`) VALUES ('10003', 'pequeña');


INSERT INTO `pizza_categoria` (`cod_cate`, `nombre`, `imagen`, `descripcion`) VALUES ('CAT0001', 'Hawaiana', 'Hawaiana.jpg', 'Pizza con queso, jamón y rodajas de piña.');
INSERT INTO `pizza_categoria` (`cod_cate`, `nombre`, `imagen`, `descripcion`) VALUES ('CAT0002', 'Americana', 'Americana.jpg', 'Pizza con salsa de tomate, queso y rodajas de jamón.');


INSERT INTO `pizza` (`cod_pizza`, `detalle`, `precio`, `pizza_categoria_cod_cate`, `tamano_cod_Tam`) VALUES ('PIZ0001', 'PIZZA BIEN HECHA PARA SUS GUSTOS', '24.50', 'CAT0001', '10002');
INSERT INTO `pizza` (`cod_pizza`, `detalle`, `precio`, `pizza_categoria_cod_cate`, `tamano_cod_Tam`) VALUES ('PIZ0002', 'PIZZA JFRNAOFWA', '39.99', 'CAT0002', '10001');

INSERT INTO `gaseosa` (`cod_gaseosa`, `marca`, `tamano`, `precio`, `descripcion`, `imagen`) VALUES ('GAS0001', 'COCACOLA', '1 LITRO', '6.5', 'Cocacola de un litro listo para tomar con tus causas.', 'cocacola1L.jsp');
INSERT INTO `gaseosa` (`cod_gaseosa`, `marca`, `tamano`, `precio`, `descripcion`, `imagen`) VALUES ('GAS0002', 'FANTA', '650 mililitrios', '4', 'Toma tu fanta que te vuelve fantastico XD.', 'fantastico.jsp');

INSERT INTO `promocion_pizza` (`cod_prom`, `nombre`, `cant_pizza`, `cantidad_gaseosa`, `img`, `precio`, `Pizza_cod_pizza`, `gaseosa_cod_gaseosa`) VALUES ('PRO0001', 'Promo alien', '2', '3', 'proA.jpg', '27.5', 'PIZ0001', 'GAS0002');
INSERT INTO `promocion_pizza` (`cod_prom`, `nombre`, `cant_pizza`, `cantidad_gaseosa`, `img`, `precio`, `Pizza_cod_pizza`, `gaseosa_cod_gaseosa`) VALUES ('PRO0002', 'Promo del mañana', '2', '4', 'proM', '49.90', 'PIZ0001', 'GAS0001');

INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('1', '98653245 Rosalía villegas', '2023-07-10', '4');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('2', '68952347 Juliana Alvarés', '2023-07-16', '3');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES (NULL, '85296374 Mariana Guzman', '2023-07-06', '1');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES (NULL, '85964852 Keith Gomez', '2023-07-06', '2');

