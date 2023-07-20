/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  sebas
 * Created: 15 jul. 2023
 */

-- Esta en MySQL --
DROP DATABASE IF EXISTS pizzeria;
CREATE DATABASE pizzeria;
USE pizzeria;

CREATE TABLE Factura (
    cod_pag varchar(30)  NOT NULL,
    fecha date  NOT NULL,
    pago_total decimal(10,2)  NOT NULL,
    Metodo_Pago_cod_met int  NOT NULL,
    Orden_cod_orden int  NOT NULL,
    CONSTRAINT Factura_pk PRIMARY KEY  (cod_pag)
);

-- Table: Metodo_Pago
CREATE TABLE Metodo_Pago (
    cod_met int  NOT NULL,
    tipo_pago varchar(30)  NOT NULL,
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
    precio decimal(10,2)  NOT NULL,
    pizza_categoria_cod_cate varchar(10)  NOT NULL,
    tamano_cod_Tam int  NOT NULL,
    stock int NOT NULL,
    CONSTRAINT Pizza_pk PRIMARY KEY  (cod_pizza)
);

-- Table: detalle_gaseosa
CREATE TABLE detalle_gaseosa (
    cantidad int  NOT NULL,
    precio decimal(10,2)  NOT NULL,
    Orden_cod_orden int  NOT NULL,
    gaseosa_cod_gaseosa varchar(30)  NOT NULL,
    CONSTRAINT detalle_gaseosa_pk PRIMARY KEY  (Orden_cod_orden,gaseosa_cod_gaseosa)
);

-- Table: detalle_pizza
CREATE TABLE detalle_pizza (
    cantidad int  NOT NULL,
    precio decimal(10,2)  NOT NULL,
    Orden_cod_orden int  NOT NULL,
    Pizza_cod_pizza varchar(30)  NOT NULL,
    CONSTRAINT detalle_pizza_pk PRIMARY KEY  (Orden_cod_orden,Pizza_cod_pizza)
);

-- Table: detalle_promocion
CREATE TABLE detalle_promocion (
    canttidad int  NOT NULL,
    precio decimal(10,2)  NOT NULL,
    Orden_cod_orden int  NOT NULL,
    promocion_pizza_cod_prom varchar(50)  NOT NULL,
    CONSTRAINT detalle_promocion_pk PRIMARY KEY  (Orden_cod_orden,promocion_pizza_cod_prom)
);

-- Table: gaseosa
CREATE TABLE gaseosa (
    cod_gaseosa varchar(30)  NOT NULL,
    marca varchar(30)  NOT NULL,
    tamano varchar(30)  NOT NULL,
    precio decimal(10,2)  NOT NULL,
    descripcion varchar(200)  NOT NULL,
    imagen varchar(100)  NOT NULL,
    stock int NOT NULL,
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
    precio decimal(10,2)  NOT NULL,
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


-- Usuarios
INSERT INTO `usuario` (`cod_usu`, `nombre`, `correo`, `contrasena`, `rol`) VALUES ('1', 'Javier', 'javier32@gmail.com', 'javier', 'administrador');
INSERT INTO `usuario` (`cod_usu`, `nombre`, `correo`, `contrasena`, `rol`) VALUES (NULL, 'Sebastian', 'sebas@gmail.com', 'sabes', 'administrador');
INSERT INTO `usuario` (`cod_usu`, `nombre`, `correo`, `contrasena`, `rol`) VALUES (NULL, 'Jefry', 'jefry09@gmail.com', 'yrfej', 'administrador');
INSERT INTO `usuario` (`cod_usu`, `nombre`, `correo`, `contrasena`, `rol`) VALUES (NULL, 'Derick', 'derick@gmail.com', 'kcired', 'administrador');


-- tamaño
INSERT INTO `tamano` (`cod_Tam`, `nombre`) VALUES ('10001', 'grande');
INSERT INTO `tamano` (`cod_Tam`, `nombre`) VALUES ('10002', 'mediano');
INSERT INTO `tamano` (`cod_Tam`, `nombre`) VALUES ('10003', 'pequeña');


INSERT INTO `pizza_categoria` (`cod_cate`, `nombre`, `imagen`, `descripcion`) VALUES ('C0001', 'Hawaiana', 'Hawaiana.jpg', 'Pizza con queso, jamón y rodajas de piña.');
INSERT INTO `pizza_categoria` (`cod_cate`, `nombre`, `imagen`, `descripcion`) VALUES ('C0002', 'Americana', 'Americana.jpg', 'Pizza con salsa de tomate, queso y rodajas de jamón.');


INSERT INTO `pizza` (`cod_pizza`, `detalle`, `precio`, `pizza_categoria_cod_cate`, `tamano_cod_Tam`, `stock`) VALUES ('P0001', 'PIZZA BIEN HECHA PARA SUS GUSTOS', '24.50', 'C0001', '10002', '100');
INSERT INTO `pizza` (`cod_pizza`, `detalle`, `precio`, `pizza_categoria_cod_cate`, `tamano_cod_Tam`, `stock`) VALUES ('P0002', 'PIZZA JFRNAOFWA', '39.50', 'C0002', '10001', '110');
INSERT INTO `pizza` (`cod_pizza`, `detalle`, `precio`, `pizza_categoria_cod_cate`, `tamano_cod_Tam`, `stock`) VALUES ('P0003', 'PIZZA xddxxdxdxdxdx', '40', 'C0001', '10002', '200');

INSERT INTO `gaseosa` (`cod_gaseosa`, `marca`, `tamano`, `precio`, `descripcion`, `imagen`, `stock`) VALUES ('G0001', 'COCACOLA', '1 LITRO', '6.5', 'Cocacola de un litro listo para tomar con tus causas.', 'cocacola1L.jsp', '150');
INSERT INTO `gaseosa` (`cod_gaseosa`, `marca`, `tamano`, `precio`, `descripcion`, `imagen`, `stock`) VALUES ('G0002', 'FANTA', '650 mililitrios', '5', 'Tomar tu fanta que te vuelve fantastico XD.', 'fantastico.jsp', '130');

INSERT INTO `promocion_pizza` (`cod_prom`, `nombre`, `cant_pizza`, `cantidad_gaseosa`, `img`, `precio`, `Pizza_cod_pizza`, `gaseosa_cod_gaseosa`) VALUES ('R0001', 'Promo alien', '2', '3', 'proA.jpg', '27.5', 'P0001', 'G0002');
INSERT INTO `promocion_pizza` (`cod_prom`, `nombre`, `cant_pizza`, `cantidad_gaseosa`, `img`, `precio`, `Pizza_cod_pizza`, `gaseosa_cod_gaseosa`) VALUES ('R0002', 'Promo del mañana', '2', '4', 'proM', '49.90', 'P0001', 'G0001');

INSERT INTO `metodo_pago` (`cod_met`, `tipo_pago`) VALUES ('1001', 'Efectivo');
INSERT INTO `metodo_pago` (`cod_met`, `tipo_pago`) VALUES ('1002', 'Tarjeta');

INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('1', '98653245 Rosalía villegas', '2023-07-10', '4');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('2', '68952347 Juliana Alvarés', '2023-07-16', '3');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('3', '85296374 Mariana Guzman', '2023-07-06', '1');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('4', '85964852 Keith Gomez', '2023-07-06', '2');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('5', '64315792 Juan Suarez', '2023-05-06', '3'); 
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('6', '64315795 Pedro Farfan', '2023-05-06', '4');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('7', '31975468 Julian Fulga', '2023-05-06', '2');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('8', '13462972 Ariana Bonachera', '2023-01-06', '1');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('9', '79264319 Adan Silva', '2023-01-06', '2'); 
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('10', '46731642 Moises Espinoza', '2023-06-30', '2');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('11', '16472468 Luis Gonzales', '2023-06-12', '1'); 
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('12', '26434677 Miguel Araugo', '2023-10-05', '1');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('13', '46197326 Son Goku', '2023-10-17', '1'); 
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('14', '13467262 Cassidy Fishman', '2023-12-20', '1');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('15', '13136727 Bruno Dias', '2023-12-29', '3');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('16', '99643766 Hector Lavo', '2023-03-09', '3');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('17', '43467251 Jean Pool', '2023-03-25', '3'); 
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('18', '55647297 Jefferson Katsy', '2023-04-18', '3');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('19', '33567229 Artica Miranda', '2023-04-19', '4'); 
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('20', '77261279 Axel Roca', '2023-05-16', '4');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('21', '88127643 Angela Varillas', '2023-08-22', '4'); 
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('22', '67336176 Fiorela Mendoza', '2022-08-31', '4');
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('23', '23627951 Jarumy Guillen', '2022-09-30', '2'); 
INSERT INTO `orden` (`cod_orden`, `Nobre`, `fecha`, `usuario_cod_usu`) VALUES ('69', '13726577 Betsy Block', '2022-09-09', '1');


INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('2', '79', '1', 'P0002');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('1', '49', '2', 'P0001');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('1', '49', '5', 'P0001');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('1', '49', '6', 'P0001');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('2', '79', '7', 'P0002');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('1', '49', '8', 'P0001');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('1', '49', '9', 'P0001');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('2', '79', '10', 'P0002');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('1', '49', '13', 'P0001');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('1', '49', '12', 'P0001');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('2', '79', '20', 'P0002');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('1', '49', '21', 'P0001');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('1', '49', '69', 'P0001');
INSERT INTO `detalle_pizza` (`cantidad`, `precio`, `Orden_cod_orden`, `Pizza_cod_pizza`) VALUES ('1', '49', '11', 'P0001');

INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('2', '13', '1', 'G0001');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('3', '15', '2', 'G0002');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('1', '15', '6', 'G0002');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('3', '15', '11', 'G0002');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('1', '15', '13', 'G0002');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('3', '15', '12', 'G0002');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('1', '15', '19', 'G0002');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('3', '15', '15', 'G0001');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('1', '15', '69', 'G0002');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('3', '15', '8', 'G0002');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('1', '15', '7', 'G0001');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('3', '15', '22', 'G0001');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('1', '15', '8', 'G0001');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('3', '15', '21', 'G0001');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('3', '15', '23', 'G0001');
INSERT INTO `detalle_gaseosa` (`cantidad`, `precio`, `Orden_cod_orden`, `gaseosa_cod_gaseosa`) VALUES ('1', '15', '20', 'G0002');

INSERT INTO `detalle_promocion` (`canttidad`, `precio`, `Orden_cod_orden`, `promocion_pizza_cod_prom`) VALUES ('1', '27.5', '3', 'R0001');
INSERT INTO `detalle_promocion` (`canttidad`, `precio`, `Orden_cod_orden`, `promocion_pizza_cod_prom`) VALUES ('2', '99.8', '4', 'R0002');
INSERT INTO `detalle_promocion` (`canttidad`, `precio`, `Orden_cod_orden`, `promocion_pizza_cod_prom`) VALUES ('2', '99.8', '14', 'R0002');
INSERT INTO `detalle_promocion` (`canttidad`, `precio`, `Orden_cod_orden`, `promocion_pizza_cod_prom`) VALUES ('1', '27.5', '15', 'R0001');
INSERT INTO `detalle_promocion` (`canttidad`, `precio`, `Orden_cod_orden`, `promocion_pizza_cod_prom`) VALUES ('1', '27.5', '16', 'R0001');
INSERT INTO `detalle_promocion` (`canttidad`, `precio`, `Orden_cod_orden`, `promocion_pizza_cod_prom`) VALUES ('1', '27.5', '17', 'R0001');
INSERT INTO `detalle_promocion` (`canttidad`, `precio`, `Orden_cod_orden`, `promocion_pizza_cod_prom`) VALUES ('2', '99.8', '18', 'R0002');



INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0001', '2023-07-17', '92', '1001', '1');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0002', '2023-06-17', '64', '1001', '2');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0003', '2023-07-14', '27.5', '1002', '3');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0004', '2023-07-13', '99.8', '1002', '4');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0005', '2023-05-06', '99.8', '1002', '5');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0006', '2023-05-06', '99.8', '1002', '6');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0007', '2023-05-06', '99.8', '1002', '7');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0008', '2023-01-06', '99.8', '1002', '8');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0009', '2023-01-06', '99.8', '1001', '9');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0010', '2023-06-30', '99.8', '1001', '10');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0011', '2023-06-12', '99.8', '1001', '11');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0012', '2023-10-05', '99.8', '1001', '12');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0013', '2023-10-17', '99.8', '1001', '13');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0014', '2023-12-20', '99.8', '1002', '14');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0015', '2023-12-29', '99.8', '1002', '15');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0016', '2023-03-09', '99.8', '1002', '16');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0017', '2023-03-25', '99.8', '1002', '17');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0018', '2023-04-18', '99.8', '1002', '18');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0019', '2023-04-19', '99.8', '1001', '19');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0020', '2023-05-16', '99.8', '1001', '20');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0021', '2023-08-22', '99.8', '1001', '21');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0022', '2022-08-31', '99.8', '1002', '22');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0023', '2022-09-30', '99.8', '1002', '23');
INSERT INTO `factura` (`cod_pag`, `fecha`, `pago_total`, `Metodo_Pago_cod_met`, `Orden_cod_orden`) VALUES ('F0024', '2022-09-09', '99.8', '1002', '69');

