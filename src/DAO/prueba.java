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
//        dao_grafic dou = new dao_grafic();
        
        usuario usu = d.bususuario("javier32@gmail.com");
        
        System.out.println(usu.getRol());
        
//        List<zgrafico_FAC_x_MES> list = dou.listgrafPIZ_MES("2023");
//        for(zgrafico_FAC_x_MES x:list){
//            System.out.println(x.getCantidad()+"--"+x.getMes()+"--"+x.getSuma());
//        }
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
//        
//        for(pizza piz:lispizza){
//            System.out.println(piz.getCod_pizza()+" -- "+piz.getDetalle()+" -- "+piz.getPrecio()+" -- "+piz.getCate().getNombre()+" -- "+piz.getTam().getNombre());
//        }
//            
//        pizza piza = d.buspizza("P0002");
//            System.out.println(piza.getCod_pizza()+" -- "+piza.getDetalle()+" -- "+piza.getPrecio()+" -- "+piza.getCate().getNombre()+" -- "+piza.getTam().getNombre());            
    
            
            
//        List<gaseosas>  lisgas = d.lisgaseosas();        
//        for(gaseosas gas:lisgas){
//            System.out.println(gas.getCod_gaseosa()+" -- "+gas.getMarca()+" -- "+gas.getDescripcion()+" -- "+gas.getTamaño()+" -- "+gas.getImagen());
//        }        
//        gaseosas gase = d.busgaseosas("G0001");
//        System.out.println(gase.getCod_gaseosa()+" -- "+gase.getMarca()+" -- "+gase.getDescripcion()+" -- "+gase.getTamaño()+" -- "+gase.getImagen());
            

        List<promocion_pizza>  lispromo = d.lispromo();        
        for(promocion_pizza pro:lispromo){
            System.out.println(pro.getCod_prom()+" -- "+pro.getNombre()+" -- "+pro.getGase().getMarca()+" -- "+pro.getCant_gaseosa()+" -- "+pro.getPizza().getCate().getNombre()+" -- "+pro.getCant_pizza()+" -- "+pro.getPrecio());
        }        
        
        System.out.println(d.buspromo("R0001").getNombre());
        //buspromo
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

//        List<factura> fact = d.lisfactura();
//        for(factura fa: fact){
//            System.out.println(fa.getCod_fac()+"--"+fa.getOrd().getCod_orden()+"--"+fa.getPago());
//        }
//
//        factura a=new factura();
//                a.setFecha("2022-08-12");
//                a.setPago(100.00);
//                a.setMet(d.busmetodo(1001));
//                a.setOrd(d.busorden(4));
//        
//                d.addfactura(a);
        












//        System.out.println(d.utimo());
//        int O = 20;
//        
//        String fecha = "";
//        String nombre = "";
//        String DNI = "";
//        String NOM = "";
//        double subtotal=0;
//        double igv = 0;
//        double total=0;
//        
//        List<detalle_pizza> lisP1=new ArrayList();
//        List<detalle_gaseosa> lisG1=new ArrayList();
//        List<detalle_promocion> lisPR1=new ArrayList();
//                
//        for(factura fa:d.lisfactura()){
//            if(fa.getOrd().getCod_orden() == O){
//                total = fa.getPago();
//                fecha = fa.getFecha();
//            
//                for(orden ord: d.lisorden()){
//                    if(ord.getCod_orden() == O){
//                        nombre = ord.getNombre();
//                        //extrae los 1 primeros
//                    int largo = nombre.length(); 
//                     DNI = nombre.substring(0, 8);
//                     NOM = nombre.substring(9, largo);
//                     
//                     for(detalle_pizza piz:d.lisdetallePiza()){
//                         if(piz.getOrd().getCod_orden() == O){
//                             lisP1.add(piz);
//                         }
//                     }
//                     
//                     
//                     for(detalle_gaseosa gas:d.lisdetalleGas()){
//                         if(gas.getOrd().getCod_orden() == O){
//                             lisG1.add(gas);
//                         }
//                     }                     
//                     
//                     for(detalle_promocion pro:d.lisdetallePro()){
//                         if(pro.getOrd().getCod_orden() == O){
//                             lisPR1.add(pro);
//                         }
//                     }                     
//                     //////
//                     
//                    }
//                }
//            }
//        }
//        
//        
//        
//        //comprobacion XD
//            if(lisP1!=null){
//                for(detalle_pizza dp:lisP1){
//                    System.out.println("PIZ:"+dp.getPago());
//                }                
//            }
//            
//            if(lisG1!=null){
//                for(detalle_gaseosa dp:lisG1){
//                    System.out.println("GAS:"+dp.getPrecio());
//                }                
//            }            
//            
//            if(lisPR1!=null){
//                for(detalle_promocion dp:lisPR1){
//                    System.out.println("PRO:"+dp.getPrecio());
//                }                
//            }
//
//        subtotal = (100*total)/118;
//        igv = subtotal*0.18;     
//        System.out.println(total+"--"+igv+"--"+subtotal+"--"+fecha+"--"+DNI+"--"+NOM);
//    }
//    
//    dao d = new dao();
//
//    
//    // int O = d.utimo();
//    public void xd(int O){
//        String fecha = "";
//        String nombre = "";
//        String DNI = "";
//        String NOM = "";
//        double subtotal=0;
//        double igv = 0;
//        double total=0;
//        
//        List<detalle_pizza> lisP1=new ArrayList();
//        List<detalle_gaseosa> lisG1=new ArrayList();
//        List<detalle_promocion> lisPR1=new ArrayList();
//                
//        for(factura fa:d.lisfactura()){
//            if(fa.getOrd().getCod_orden() == O){
//                total = fa.getPago();
//                fecha = fa.getFecha();
//            
//                for(orden ord: d.lisorden()){
//                    if(ord.getCod_orden() == O){
//                        nombre = ord.getNombre();
//                        //extrae los 1 primeros
//                     DNI = nombre.substring(0, 8);
//                     NOM = nombre.substring(9, 20);
//                     
//                     for(detalle_pizza piz:d.lisdetallePiza()){
//                         if(piz.getOrd().getCod_orden() == O){
//                             lisP1.add(piz);
//                         }
//                     }
//                     
//                     
//                     for(detalle_gaseosa gas:d.lisdetalleGas()){
//                         if(gas.getOrd().getCod_orden() == O){
//                             lisG1.add(gas);
//                         }
//                     }                     
//                     
//                     for(detalle_promocion pro:d.lisdetallePro()){
//                         if(pro.getOrd().getCod_orden() == O){
//                             lisPR1.add(pro);
//                         }
//                     }                     
//                     //////
//                     
//                    }
//                }
//            }
//        }
        
        
        
        
    }
    
}
