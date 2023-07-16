/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import DAO.dao;
import Modelo_REF.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sebas
 */
public class Controlador_Empleado implements ActionListener, MouseListener{
    
    Empleado empl=new Empleado();
    usuario usu;

    public Controlador_Empleado(usuario usu) {
        this.usu = usu;
        mostrar();
        mostablapizza();
        mostablagaseosa();
        mostablapromocion();
    }
    
    dao obj = new dao();
    
    void mostablapizza(){
        DefaultTableModel dt=(DefaultTableModel)empl.JT_PIZZAS.getModel();
        dt.setRowCount(0);
        for (pizza x : obj.lispizza()) {
            Object v[]={x.getCod_pizza(),x.getPrecio(),x.getCate().getNombre(),x.getTam().getNombre()};
            dt.addRow(v);
        }
    }
    
    void mostablagaseosa(){
        DefaultTableModel dt=(DefaultTableModel)empl.JT_GASEOSAS.getModel();
        dt.setRowCount(0);
        for (gaseosas x : obj.lisgaseosas()) {
            Object v[]={x.getCod_gaseosa(),x.getPrecio(),x.getMarca(),x.getTamaño()};
            dt.addRow(v);
        }
    }
        
    void mostablapromocion(){
        DefaultTableModel dt=(DefaultTableModel)empl.JT_PROMOCION.getModel();
        dt.setRowCount(0);
        for (promocion_pizza x : obj.lispromo()) {
            Object v[]={x.getNombre(),x.getCant_gaseosa()+" "+x.getGase().getMarca(),x.getCant_pizza()+" "+x.getPizza().getCate().getNombre(),x.getPrecio()};
            dt.addRow(v);
        }
    }

    public void mostrar() {
        this.empl.setVisible(true);
    }

    public void cerrar() {
        this.empl.dispose();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
