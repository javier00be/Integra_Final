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
        List<pizza>  lispizza = d.lispizza();
        
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
            

        List<promocion_pizza>  lispromo = d.lispromo();        
        for(promocion_pizza pro:lispromo){
            System.out.println(pro.getCod_prom()+" -- "+pro.getNombre()+" -- "+pro.getGase().getMarca()+" -- "+pro.getCant_gaseosa()+" -- "+pro.getPizza().getCate().getNombre()+" -- "+pro.getCant_pizza()+" -- "+pro.getPrecio());
        }        


            
        List<usuario>  lisusu = d.lisusuarios();        
        for(usuario usu:lisusu){
            System.out.println(usu.getCod_usu()+" -- "+usu.getNombre()+" -- "+usu.getCorreo()+" -- "+usu.getContraseña()+" -- "+usu.getRol());
        }
        
        usuario usu = d.bususuario(2);
        System.out.println(usu.getCod_usu()+" -- "+usu.getNombre()+" -- "+usu.getCorreo()+" -- "+usu.getContraseña()+" -- "+usu.getRol());
        
        List<orden>  lisord = d.lisorden();        
        for(orden ord:lisord){
            System.out.println(ord.getCod_orden()+" -- "+ord.getNombre()+" -- "+ord.getFecha()+" -- "+ord.getUsu().getNombre());
        }
    }
}
