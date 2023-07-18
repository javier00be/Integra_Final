/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo_REF.*;
import java.util.*;

/**
 *
 * @author sebas
 */
public class prueba {
    public static void main(String[] args) {
        dao d = new dao();
        
//        String cod = "PRO0001";
//        String Pcod = cod.substring(0, 3);
//        System.out.println(""+Pcod);
//        
//        promocion_pizza lis =d.buspromo("PRO0002");
//        System.out.println(lis.getCod_prom()+"--"+lis.getNombre()+"--"+lis.getPizza().getCate().getNombre());
        



//        List<tamaño> list = d.listam();
//        
//        for(tamaño tam:list){
//            System.out.println(tam.getCod_Tam()+" -- "+tam.getNombre());
//        }
        
//        tamaño tam = d.bustam(10002);        
//        System.out.println(tam.getCod_Tam()+" -- "+tam.getNombre());
        
//        List<pizza_categoria> licat = d.liscat();        
//        for(pizza_categoria cat:licat){
//            System.out.println(cat.getCod_cate()+" -- "+cat.getNombre()+" -- "+cat.getImagen()+" -- "+cat.getDescripcion());
//        }
        
//        pizza_categoria cat = d.buscat("CAT0002");
//            System.out.println(cat.getCod_cate()+" -- "+cat.getNombre()+" -- "+cat.getImagen()+" -- "+cat.getDescripcion());
//        
//        List<pizza>  lispizza = d.lispizza();
        
//        for(pizza piz:lispizza){
//            System.out.println(piz.getCod_pizza()+" -- "+piz.getDetalle()+" -- "+piz.getPrecio()+" -- "+piz.getCate().getNombre()+" -- "+piz.getTam().getNombre());
//        }
//            
//        pizza piza = d.buspizza("PIZ0002");
//            System.out.println(piza.getCod_pizza()+" -- "+piza.getDetalle()+" -- "+piza.getPrecio()+" -- "+piza.getCate().getNombre()+" -- "+piza.getTam().getNombre());            
    
            
            
//        List<gaseosas>  lisgas = d.lisgaseosas();        
//        for(gaseosas gas:lisgas){
//            System.out.println(gas.getCod_gaseosa()+" -- "+gas.getMarca()+" -- "+gas.getDescripcion()+" -- "+gas.getTamaño()+" -- "+gas.getImagen());
//        }        
//        gaseosas gase = d.busgaseosas("GAS0001");
//        System.out.println(gase.getCod_gaseosa()+" -- "+gase.getMarca()+" -- "+gase.getDescripcion()+" -- "+gase.getTamaño()+" -- "+gase.getImagen());
            

//        List<promocion_pizza>  lispromo = d.lispromo();        
//        for(promocion_pizza pro:lispromo){
//            System.out.println(pro.getCod_prom()+" -- "+pro.getNombre()+" -- "+pro.getGase().getMarca()+" -- "+pro.getCant_gaseosa()+" -- "+pro.getPizza().getCate().getNombre()+" -- "+pro.getCant_pizza()+" -- "+pro.getPrecio());
//        }        
//
//
//            
//        List<usuario>  lisusu = d.lisusuarios();        
//        for(usuario usu:lisusu){
//            System.out.println(usu.getCod_usu()+" -- "+usu.getNombre()+" -- "+usu.getCorreo()+" -- "+usu.getContraseña()+" -- "+usu.getRol());
//        }
//        
//        usuario usu = d.bususuario(2);
//        System.out.println(usu.getCod_usu()+" -- "+usu.getNombre()+" -- "+usu.getCorreo()+" -- "+usu.getContraseña()+" -- "+usu.getRol());
//        
//        List<orden>  lisord = d.lisorden();        
//        for(orden ord:lisord){
//            System.out.println(ord.getCod_orden()+" -- "+ord.getNombre()+" -- "+ord.getFecha()+" -- "+ord.getUsu().getNombre());
//        }
//        
//        System.out.println(d.busorden(3).getNombre());
        
//        List<detalle_pizza>  lisdetpiz = d.lisdetallePiza();        
//        for(detalle_pizza detP:lisdetpiz){
//            System.out.println(detP.getOrd().getCod_orden()+" -- "+detP.getPiz().getCate().getNombre()+" -- "+detP.getCantidad()+" -- "+detP.getPago());
//        }
        
//        List<detalle_gaseosa>  lisdetgas = d.lisdetalleGas();      
//        for(detalle_gaseosa detg: lisdetgas){
//            System.out.println(detg.getOrd().getCod_orden()+" -- "+detg.getGas().getMarca()+" -- "+detg.getCantidad()+" -- "+detg.getPrecio());
//        }
        
//        List<detalle_promocion>  lisdetpro = d.lisdetallePro();      
//        for(detalle_promocion detpr: lisdetpro){
//            System.out.println(detpr.getOrd().getCod_orden()+" -- "+detpr.getProm().getNombre()+" -- "+detpr.getCantidad()+" -- "+detpr.getPrecio());
//        }

//        detalle_pizza dp = new detalle_pizza(d.busorden(2),d.buspizza("PIZ0002"),1,49.00);
//        d.addlisdetallePiza(dp);
        
//        detalle_gaseosa dg = new detalle_gaseosa(d.busorden(2),d.busgaseosas("GAS0002"),3,15.00);
//        d.addlisdetalleGase(dg);

//        detalle_promocion dpr = new detalle_promocion(d.busorden(4),d.buspromo("PRO0002"),2,99.8);
//        d.addlisdetallePromo(dpr);
//            orden ord = d.utimo(d.bususuario(1), "Fernando", "2023/07/14");
//            System.out.println(ord.getCod_orden()+"--"+ord.getUsu().getNombre());

//    usuario usu = d.bususuario(2);
//        orden ordpre = d.utimo(usu, "Fernando", "2023-07-14");
//        d.addorden(ordpre);
    
//        List<metodo_pago> met = d.lismetodo();
//        
//        for(metodo_pago meto:met){
//            System.out.println(meto.getCod_met()+"--"+meto.getTipo_pago());
//        }
        
//        metodo_pago meto1 = d.busmetodo(1002);
//        System.out.println(meto1.getTipo_pago());

        List<factura> fact = d.lisfactura();
        for(factura fa: fact){
            System.out.println(fa.getCod_fac()+"--"+fa.getOrd().getCod_orden()+"--"+fa.getPago());
        }

        factura a=new factura();
                a.setFecha("2022-08-12");
                a.setPago(100.00);
                a.setMet(d.busmetodo(1001));
                a.setOrd(d.busorden(4));
        
                d.addfactura(a);
        
    }
}
