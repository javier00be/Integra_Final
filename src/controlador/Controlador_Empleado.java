/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import DAO.dao;
import Modelo_REF.*;
import Vista.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sebas
 */
public class Controlador_Empleado implements ActionListener, MouseListener{
    
    Empleado empl=new Empleado();
    usuario usu;
    dao obj = new dao();

    
    public Controlador_Empleado(usuario usu) {
        this.usu = usu;
        this.empl.BTN_ANADI.addActionListener(this);
        this.empl.BTN_REMOVER.addActionListener(this);
        this.empl.BTN_VACIAR.addActionListener(this);
        this.empl.BTN_PAGAR.addActionListener(this);
        this.empl.BTN_CONFIRMA.addActionListener(this);
        this.empl.TXTCANTIDAD.addActionListener(this);
////        this.empl.TXT_IGV.addActionListener(this);
////        this.empl.TXT_TOTAL.addActionListener(this);
        this.empl.CB_MetodoPago.addActionListener(this);
        this.empl.JT_PIZZAS.addMouseListener(this);
        this.empl.JT_GASEOSAS.addMouseListener(this);
        this.empl.JT_PROMOCION.addMouseListener(this);
        this.empl.JT_CARRITO.addMouseListener(this);
        mostrar();
        mostablapizza();
        mostablagaseosa();
        mostablapromocion();
        
//        DefaultTableModel dt=(DefaultTableModel)empl.JT_CARRITO.getModel();
//        ArrayList<Object[]> info = new ArrayList<Object[]>();
//        Object Object1[]={"name1",12,24.5};
//        Object Object2[]={"name2",13,24.6};
//        Object Object3[]={"name3",14,24.7};
//        Object Object4[]={"name4",15,24.8};
//        Object Object5[]={"name5",16,24.9};
//        info.add(Object1);
//        info.add(Object2);
//        info.add(Object3);
//        info.add(Object4);
//        info.add(Object5);
//        
//        
//        for(Object[] informacion:info){
//            dt.addRow(informacion);
//        }
    }

    
    public void mostrar() {
        this.empl.setVisible(true);
    }

    public void cerrar() {
        this.empl.dispose();
        
    }

    void mostablapizza(){
        DefaultTableModel dt=(DefaultTableModel)empl.JT_PIZZAS.getModel();
        dt.setRowCount(0);
        for (pizza x : obj.lispizza()) {
            Object v[]={x.getCod_pizza(),x.getCate().getNombre(),x.getTam().getNombre(),x.getPrecio()};
            dt.addRow(v);
        }
    }
    
    void mostablagaseosa(){
        DefaultTableModel dt=(DefaultTableModel)empl.JT_GASEOSAS.getModel();
        dt.setRowCount(0);
        for (gaseosas x : obj.lisgaseosas()) {
            Object v[]={x.getCod_gaseosa(),x.getMarca(),x.getTamaño(),x.getPrecio()};
            dt.addRow(v);
        }
    }
        
    void mostablapromocion(){
        DefaultTableModel dt=(DefaultTableModel)empl.JT_PROMOCION.getModel();
        dt.setRowCount(0);
        for (promocion_pizza x : obj.lispromo()) {
            Object v[]={x.getCod_prom(),x.getCant_gaseosa()+" "+x.getGase().getMarca(),x.getCant_pizza()+" "+x.getPizza().getCate().getNombre(),x.getPrecio()};
            dt.addRow(v);
        }
    }
    
    


    int selectP = 5000;
    int selectG = 5000;
    int selectPr = 5000;
    int selectCA = 5000;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //obtiene la coordenadas del mouse o algo así xd        
    Component clickedComponent = SwingUtilities.getDeepestComponentAt(e.getComponent(), e.getX(), e.getY());
        
        //wacha si esta en un tabla el clic xd
        if (clickedComponent instanceof JTable) {
            JTable select = (JTable) clickedComponent;
            
            //compara en que tabla esta xd
            if(select == empl.JT_PIZZAS){
                selectP = empl.JT_PIZZAS.rowAtPoint(e.getPoint());
            }else{
                if(select == empl.JT_GASEOSAS){
                    selectG = empl.JT_GASEOSAS.rowAtPoint(e.getPoint());
                }else{
                    if(select == empl.JT_PROMOCION){
                        selectPr = empl.JT_PROMOCION.rowAtPoint(e.getPoint());
                    }else{
                        if(select == empl.JT_CARRITO){
                            selectCA = empl.JT_CARRITO.rowAtPoint(e.getPoint());
                        }
                    }
                }
            }
        }

    }
    
    //variables
    int post = 0;
    double subTOTAL = 0;
    double igv = 0.18;
    double igv_all = 0;
    double total = 0;
    String clienteDNI="";
    String clienteNOM="";
    orden ordpre = obj.utimo(usu, "Fernando", "2023/07/14");
    List<detalle_pizza> lisP=new ArrayList();
    List<detalle_gaseosa> lisG=new ArrayList();
    List<detalle_promocion> lisPR=new ArrayList();
    
    
    void añadircarrito(String cod, int cantidad, double precio, int post){
        empl.TXT_ORDEN.setText(""+ordpre.getCod_orden());
        DefaultTableModel dt=(DefaultTableModel)empl.JT_CARRITO.getModel();
        dt.setRowCount(post);
        //extrae los 3 primeros
        String Pcod = cod.substring(0, 1);
        empl.TXTAREA.append(""+Pcod);
        
        //agrega a una lista de acuerdo al producto
        if(Pcod.equals("P")){
            detalle_pizza a=new detalle_pizza(ordpre,obj.buspizza(cod),cantidad,precio);
            lisP.add(a);
            empl.TXTAREA.append("ENTRADO PIZ");
        }
        
        if(Pcod.equals("G")){
            detalle_gaseosa a=new detalle_gaseosa(ordpre,obj.busgaseosas(cod),cantidad,precio);
            lisG.add(a);
            empl.TXTAREA.append("ENTRADO GAS");
        }
                
        if(Pcod.equals("R")){
            detalle_promocion a = new detalle_promocion(ordpre,obj.buspromo(cod),cantidad,precio);
            lisPR.add(a);
            empl.TXTAREA.append("ENTRADO PRO");
        }
        
        Object v[]={cod,cantidad,precio};
        dt.addRow(v);
    }
    
    private boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean eliminar(String cod){
        
        boolean hallar = false;
        //extrae los 3 primeros
        String Pcod = cod.substring(0, 1);
        
        //agrega a una lista de acuerdo al producto
        if(Pcod.equals("P")){
            for(int cont = 0;cont<lisP.size();cont++){            
                if(lisP.get(cont).getPiz().getCod_pizza().equals(cod)){
                    hallar = true;
                    lisP.remove(cont);
                }            
            }            
        }
        
        if(Pcod.equals("G")){
            for(int cont = 0;cont<lisG.size();cont++){            
                if(lisG.get(cont).getGas().getCod_gaseosa().equals(cod)){
                    hallar = true;
                    lisG.remove(cont);
                }            
            }
        }
                
        if(Pcod.equals("R")){
            for(int cont = 0;cont<lisPR.size();cont++){            
                if(lisPR.get(cont).getProm().getCod_prom().equals(cod)){
                    hallar = true;
                    lisPR.remove(cont);
                }            
            }
        }
        return hallar;
    }
    
    public void mostrarcompra(){

            for(detalle_pizza piz:lisP){            
                empl.TXTAREA.append(" "+piz.getPiz().getCate().getNombre()+"        "+piz.getCantidad()+"x  S./"+piz.getPiz().getPrecio()+"                         "+piz.getPago()+"\n");
                empl.TXTAREA.append(" *"+piz.getPiz().getTam().getNombre()+"\n\n");
            }            

            for(detalle_gaseosa gas:lisG){            
                empl.TXTAREA.append(" "+gas.getGas().getMarca()+"        "+gas.getCantidad()+"x  S./"+gas.getGas().getPrecio()+"                         "+gas.getPrecio()+"\n");
                empl.TXTAREA.append(" *"+gas.getGas().getTamaño()+"\n\n");
            }

            for(detalle_promocion pro:lisPR){            
                empl.TXTAREA.append(" "+pro.getProm().getCod_prom()+"        "+pro.getCantidad()+"x  S./"+pro.getProm().getPrecio()+"                         "+pro.getPrecio()+"\n");
                empl.TXTAREA.append(" *"+pro.getProm().getGase().getMarca()+"        "+pro.getProm().getGase().getTamaño()+" "+pro.getProm().getCant_gaseosa()+"\n");
                empl.TXTAREA.append(" *"+pro.getProm().getPizza().getCate().getNombre()+"        "+pro.getProm().getPizza().getTam().getNombre()+"          \n\n");
            }
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //boton añadir
        if (e.getSource() == empl.BTN_ANADI) {  
            
            String nom = "";
            int cant=0;
            
            if(isNumeric(empl.TXTCANTIDAD.getText())){
                cant = Integer.parseInt(empl.TXTCANTIDAD.getText());
                
            }else{
                JOptionPane.showInputDialog("Se debe colocar un número en cantidad");
                
            }
            
            double precio = 0,canPRE;
            
            if(selectP != 5000){   
                nom = (String.valueOf(empl.JT_PIZZAS.getValueAt(selectP, 0)));
                precio = (Double.parseDouble(String.valueOf( empl.JT_PIZZAS.getValueAt(selectP, 3))));
                empl.TXTAREA.append(""+nom+precio+"\n");
            }
            
            if(selectG != 5000){
                nom = (String.valueOf(empl.JT_GASEOSAS.getValueAt(selectG, 0)));
                precio = (Double.parseDouble(String.valueOf( empl.JT_GASEOSAS.getValueAt(selectG, 3))));
                empl.TXTAREA.append(""+nom+precio+"\n");
//                empl.TXTAREA.append(String.valueOf(empl.JT_GASEOSAS.getValueAt(selectG, 0)));
//                empl.TXTAREA.append(String.valueOf(empl.JT_GASEOSAS.getValueAt(selectG, 1)));
//                empl.TXTAREA.append(String.valueOf(empl.JT_GASEOSAS.getValueAt(selectG, 2)+"\n"));                
            }

//            
            if(selectPr != 5000){
                nom = (String.valueOf(empl.JT_PROMOCION.getValueAt(selectPr, 0)));
                precio = (Double.parseDouble(String.valueOf( empl.JT_PROMOCION.getValueAt(selectPr, 3))));
                empl.TXTAREA.append(""+nom+precio+"\n");
//                empl.TXTAREA.append(String.valueOf(empl.JT_PROMOCION.getValueAt(selectPr, 0)));
//                empl.TXTAREA.append(String.valueOf(empl.JT_PROMOCION.getValueAt(selectPr, 1)));
//                empl.TXTAREA.append(String.valueOf(empl.JT_PROMOCION.getValueAt(selectPr, 2)+"\n"));                
            }
             
            if(precio==0.0 || nom=="" || cant==0){
                JOptionPane.showInputDialog("wey falta señalar xd");
            }else{
                
            //se halla el precio por cantidad
            canPRE = cant * precio;
            añadircarrito(nom,cant,canPRE, post);
            
            //contador para poner debajo en la fila de tablas
            post++;
            
            //aumentador para saber el subtotal
            subTOTAL = subTOTAL + canPRE ;
            
            //se agrega al txtsubtotal para visualizar en el txtSUBTOTAL
            empl.TXT_SUBTOTAL.setText(""+subTOTAL);
            
            //se agrega al txtigv y txt total

            igv_all = subTOTAL*igv;
            total = igv_all + subTOTAL;
            empl.TXT_IGV.setText(""+igv_all);
            empl.TXT_TOTAL.setText(""+total);
            
            empl.TXTAREA.append(" "+selectP);
            empl.TXTAREA.append(" "+selectG);
            empl.TXTAREA.append(" "+selectPr);
            
            selectP = 5000;
            selectG = 5000;
            selectPr = 5000;


            empl.TXTAREA.append("xd\n");
            
            
            }
            
        }
        
        
        
        //boton remover
        if (e.getSource() == empl.BTN_REMOVER) {  
            String Cod1 = "";
            double monto = 0;
            
            if(selectCA != 5000){
                DefaultTableModel dt=(DefaultTableModel)empl.JT_CARRITO.getModel();
                
                int selectedRow = empl.JT_CARRITO.getSelectedRow();                                               

                if(isNumeric(String.valueOf(empl.JT_CARRITO.getValueAt(selectCA, 2)))){
                    Cod1 = String.valueOf(empl.JT_CARRITO.getValueAt(selectCA, 0));
                    monto = Double.parseDouble(String.valueOf(empl.JT_CARRITO.getValueAt(selectCA, 2)));
                    
                    if(subTOTAL==0 || subTOTAL<0){
                        
                        post = 0;
                        subTOTAL=0;
                        empl.TXT_SUBTOTAL.setText(""+subTOTAL);
                    //se agrega al txtigv y txt total

                        igv_all = subTOTAL*igv;
                        total = igv_all + subTOTAL;
                        
                        empl.TXT_IGV.setText(""+igv_all);
                        empl.TXT_TOTAL.setText(""+total);
                        empl.TXTAREA.append(""+Cod1);
                        eliminar(Cod1);
                        
                        }else{
                        
                        if(post>0){
                          post = post - 1;
                        }                          
                        
                        //aumentador para saber el subtotal
                        subTOTAL = subTOTAL - monto;
                        empl.TXT_SUBTOTAL.setText(""+subTOTAL);
                    //se agrega al txtigv y txt total

                        igv_all = subTOTAL*igv;
                        total = igv_all + subTOTAL;
                        empl.TXT_IGV.setText(""+igv_all);
                        empl.TXT_TOTAL.setText(""+total);
                        
                        empl.TXTAREA.append(""+Cod1);
                        eliminar(Cod1);
                        
                        dt.removeRow(selectedRow);
                    }
                    
                }else{
                    JOptionPane.showInputDialog("No se encontro numero xd");
                }
                
                
                //se agrega al txtsubtotal para visualizar
                empl.TXTAREA.append(" "+selectCA+"--"+selectedRow+"monto:->" +monto+"sub--"+subTOTAL+"p--"+post);
                empl.TXTAREA.append("xd\n");
                                
                selectCA = 5000;
                
            }
            
        }
        
        
        
        //boton vaciar
        if (e.getSource() == empl.BTN_VACIAR) { 
            DefaultTableModel dt=(DefaultTableModel)empl.JT_CARRITO.getModel();
            int fila = dt.getRowCount();
            
            //pasa por toda la tabla borrando cada fila
            for(int i = fila-1;i>=0;i--){
                dt.removeRow(i);
            }
            
            //vacia el txtarea
            empl.TXTAREA.setText("");
            
            //aumentador para saber el subtotal
                post = 0;
                subTOTAL = 0;
                empl.TXT_SUBTOTAL.setText(""+subTOTAL);
            //se agrega al txtigv y txt total
                //ASIGNA IGV DEL SUBTOTAL Y SUMA DEL IGV CON SUBTOTAL = TOTAL PRECIO
                igv_all = subTOTAL*igv;
                total = igv_all + subTOTAL;
                
                empl.TXT_IGV.setText(""+igv_all);
                empl.TXT_TOTAL.setText(""+total);
            
            
            subTOTAL = 0;
            empl.TXT_SUBTOTAL.setText(""+subTOTAL);
        }
        
        
        
        //boton pagar
        if (e.getSource() == empl.BTN_PAGAR) {
            
            clienteDNI = empl.TXT_DNI.getText();
            clienteNOM = empl.TXT_NOMBRE.getText();
            //obtiene la fecha actual
            LocalDate fechaActual = LocalDate.now();
            
            //comienza el boucher
            empl.TXTAREA.setText("");
            empl.TXTAREA.append("                          La pizzería 'Del Tano'                   \n");
            empl.TXTAREA.append("                             Cercado de Lima                       \n");
            empl.TXTAREA.append("                          Av.Oscar de benavides                    \n");
            empl.TXTAREA.append("                             +51 9956 2548                         \n");
            empl.TXTAREA.append(" ------------------------------------------------------------------\n");
            empl.TXTAREA.append(" Factura: \n");
            empl.TXTAREA.append(" Fecha: "+fechaActual+" \n");
            empl.TXTAREA.append(" DNI del cliente: "+clienteDNI+"\n");
            empl.TXTAREA.append(" Nombre del cliente: "+clienteNOM+"\n");
            empl.TXTAREA.append(" ------------------------------------------------------------------\n");
            empl.TXTAREA.append("   ITEM                CANTIDAD                SUBTOTAL     \n");
            empl.TXTAREA.append(" ------------------------------------------------------------------\n");

            mostrarcompra();
            
            empl.TXTAREA.append(" ------------------------------------------------------------------\n");
            empl.TXTAREA.append(" SUBTOTAL                                               "+subTOTAL+"\n");
            empl.TXTAREA.append(" IGV (18%)                                              "+igv_all+"\n");
            empl.TXTAREA.append(" TOTAL                                                  "+total+"\n");
            empl.TXTAREA.append(" PAGADO                                                 "+total+"\n");
            empl.TXTAREA.append(" VUELT                                                  "+total+"\n");
            empl.TXTAREA.append(" =====================================\n");
            empl.TXTAREA.append(" 'Gracias por escoger nuestro restaurante, a sido \n");
            empl.TXTAREA.append(" un placer brindarle nuestro servicio para que usted \n");
            empl.TXTAREA.append(" pueda solicitar su pedido y disfrutarlo. Te espera-\n");
            empl.TXTAREA.append(" mos para pa proxima vez que vengas. \n");
            empl.TXTAREA.append(" Tenga buen día.'\n");
            

        }
        
        
        if(e.getSource() == empl.CB_MetodoPago){
            String met = empl.CB_MetodoPago.getSelectedItem().toString();
            if(met.equals("Efectivo")){
                empl.TXT_PAGO.setEditable(true);
            }else{
                empl.TXT_PAGO.setEditable(false);
            }
            
        }
        
        
        if(e.getSource() == empl.BTN_CONFIRMA){
            LocalDate fechaActual = LocalDate.now();
            String fec = String.valueOf(fechaActual);
            String persona = empl.TXT_DNI.getText()+" "+empl.TXT_NOMBRE.getText();
            orden ORD = obj.utimo(usu, persona, fec);
            obj.addorden(ORD);
            
            if(lisP!=null){
                for(detalle_pizza dp:lisP){
                    obj.addlisdetallePiza(dp);
                }                
            }
            
            if(lisG!=null){
                for(detalle_gaseosa dp:lisG){
                    obj.addlisdetalleGase(dp);
                }                
            }            
            
            if(lisPR!=null){
                for(detalle_promocion dp:lisPR){
                    obj.addlisdetallePromo(dp);
                }                
            }


            factura a=new factura();
                a.setFecha(fec);
                a.setPago(total);
                a.setMet(obj.busmetodo(1001));
                a.setOrd(ORD);
                
                obj.addfactura(a);

        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
}

