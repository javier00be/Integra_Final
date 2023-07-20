/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  sebas
 * Created: 18 jul. 2023
 */

-- select cod_orden from orden ORDER BY cod_orden DESC LIMIT 1

drop procedure if exists nuevo_factura; 
DELIMITER // 
create procedure nuevo_factura(fecha date, pago_total decimal(5,2), met_pago int, orden int)
BEGIN
declare num int;
declare codfac char(5);
set num = (select ifnull(max(convert(substring(cod_pag,2), signed integer)),'0') from factura)+1;
set codfac = concat('F',LPAD(num,4,'0')); 
INSERT INTO factura (cod_pag, fecha, pago_total, Metodo_Pago_cod_met, Orden_cod_orden) VALUES (codfac, fecha, pago_total, met_pago, orden);
end //
delimiter ;



drop procedure if exists obt_piz; 
DELIMITER // 
create procedure obt_piz(FECHAA varchar(4))
BEGIN

SELECT MONTH(o.fecha) AS MES, COUNT(*) AS CANTIDAD, SUM(p.precio) AS TOTAL FROM detalle_pizza p, orden o WHERE p.Orden_cod_orden = o.cod_orden and YEAR(o.fecha) = FECHAA GROUP BY MONTH(o.fecha);
end //
delimiter ;


drop procedure if exists obt_gas; 
DELIMITER // 
create procedure obt_gas(FECHAA varchar(4))
BEGIN

SELECT MONTH(o.fecha) AS MES, COUNT(*) AS CANTIDAD, SUM(p.precio) AS TOTAL FROM detalle_gaseosa p, orden o WHERE p.Orden_cod_orden = o.cod_orden and YEAR(o.fecha) = FECHAA GROUP BY MONTH(o.fecha);
end //
delimiter ;



drop procedure if exists obt_pro; 
DELIMITER // 
create procedure obt_pro(FECHAA varchar(4))
BEGIN

SELECT MONTH(o.fecha) AS MES, COUNT(*) AS CANTIDAD, SUM(p.precio) AS TOTAL FROM detalle_promocion p, orden o WHERE p.Orden_cod_orden = o.cod_orden and YEAR(o.fecha) = FECHAA GROUP BY MONTH(o.fecha);
end //
delimiter ;




drop procedure if exists nuevo_promocion_pizza; 
DELIMITER //

CREATE PROCEDURE nuevo_promocion_pizza(
  IN nom VARCHAR(100),
  IN cantpizza INT,
  IN cantgaseosa INT,
  IN im VARCHAR(100),
  IN prec DECIMAL(10, 2),
  IN Pizzacodpizza VARCHAR(50),
  IN gaseosacodgaseosa VARCHAR(50)
)
BEGIN
  DECLARE num INT;
  DECLARE codprom CHAR(5);

  -- Verificar si el valor de Pizzacodpizza existe en la tabla pizza
  DECLARE pizzaExists INT;
  SELECT COUNT(*) INTO pizzaExists FROM pizza WHERE cod_pizza = Pizzacodpizza;
  
  IF pizzaExists = 0 THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'El valor de Pizzacodpizza no existe en la tabla pizza.';
  ELSE
    SELECT IFNULL(MAX(CONVERT(SUBSTRING(cod_prom, 2), SIGNED INTEGER)), 0) + 1 INTO num FROM promocion_pizza;
  
    SET codprom = CONCAT('R', LPAD(num, 4, '0')); 
  
    INSERT INTO promocion_pizza (cod_prom, nombre, cant_pizza, cantidad_gaseosa, img, precio, Pizza_cod_pizza, gaseosa_cod_gaseosa)
    VALUES (codprom, nom, cantpizza, cantgaseosa, im, prec, Pizzacodpizza, gaseosacodgaseosa);
  END IF;
END //

DELIMITER ;