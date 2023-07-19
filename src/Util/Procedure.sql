/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  sebas
 * Created: 18 jul. 2023
 */

-- select cod_orden from orden ORDER BY cod_orden DESC LIMIT 1
	begin DROP procedure IF EXISTS FAC end 
go
	create procedure factura
            @fecha date, @pago_total decimal(5,2), @met_pago int, @orden int
	as
	declare @codfac varchar(5)=(select 'F'+right('00000'+convert(varchar,isnull(Max(right(Trabajadores_id,4)),0)+1),4) from Trabajadores);
        INSERT INTO factura (cod_pag, fecha, pago_total, Metodo_Pago_cod_met, Orden_cod_orden) VALUES (@codfac, @fecha, @pago_total, @met_pago, @orden)
go



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

-- 