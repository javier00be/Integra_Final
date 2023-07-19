/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.dao_grafic;
import Modelo_REF.zgrafico_FAC_x_MES;
import Vista.grafic;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author sebas
 */
public class Controlador_grafico implements ActionListener, MouseListener{
    
    grafic gra= new grafic();
    dao_grafic d = new dao_grafic();
    int boton = 0;
        


    public Controlador_grafico() {
        this.gra.CB_variable.addActionListener(this);
        this.gra.CB_anio.addActionListener(this);
        this.gra.btn_torta.addActionListener(this);
        this.gra.btn_mes.addActionListener(this);
        this.gra.btn_linea.addActionListener(this);
        mostrar();
        combos();
    }
    

    public void mostrar() {
        this.gra.setVisible(true);
    }
    
    public void combos() {
        gra.CB_anio.removeAllItems();
        
        List<String> list = d.listgra();
        for(String x:list){
            System.out.println(x);
            gra.CB_anio.addItem(x);
        }
        
        
        gra.CB_variable.removeAllItems();
        gra.CB_variable.addItem("pizzas");
        gra.CB_variable.addItem("gaseosas");
        gra.CB_variable.addItem("promociones");

    }
    
    public void verTB_F_M_PIZ(){
        DefaultTableModel dt=(DefaultTableModel)gra.TB_mostrar_variable.getModel();
        String met = gra.CB_anio.getSelectedItem().toString();
        dt.setRowCount(0);
        for(zgrafico_FAC_x_MES x: d.listgrafPIZ_MES(met)){
            Object v[]={x.getMes(),x.getCantidad(),x.getSuma()};
            dt.addRow(v);
        }
    }
    
    public void verTB_F_M_GAS(){
        DefaultTableModel dt=(DefaultTableModel)gra.TB_mostrar_variable.getModel();
        String met = gra.CB_anio.getSelectedItem().toString();
        dt.setRowCount(0);
        for(zgrafico_FAC_x_MES x: d.listgrafGAS_MES(met)){
            Object v[]={x.getMes(),x.getCantidad(),x.getSuma()};
            dt.addRow(v);
        }
    }
        
    public void verTB_F_M_PRO(){
        DefaultTableModel dt=(DefaultTableModel)gra.TB_mostrar_variable.getModel();
        String met = gra.CB_anio.getSelectedItem().toString();
        dt.setRowCount(0);
        for(zgrafico_FAC_x_MES x: d.listgrafPRO_MES(met)){
            Object v[]={x.getMes(),x.getCantidad(),x.getSuma()};
            dt.addRow(v);
        }
    }
    
    void barramesPIZ(){
        DefaultCategoryDataset ds=new DefaultCategoryDataset();
        String met = gra.CB_anio.getSelectedItem().toString();
        
        for(zgrafico_FAC_x_MES g: d.listgrafPIZ_MES(met)){
            ds.setValue(g.getSuma(), "venta", g.getMes());
        }
        JFreeChart gf=ChartFactory.createBarChart3D("MES ","Mes", "MONTO", ds);
        ChartPanel cp = new ChartPanel(gf);
        gra.Panel.removeAll();
        gra.Panel.setLayout(new java.awt.BorderLayout());
        gra.Panel.add(cp,BorderLayout.CENTER);
        gra.Panel.validate();
    }
    
    
    void barramesGAS(){
        DefaultCategoryDataset ds=new DefaultCategoryDataset();
        String met = gra.CB_anio.getSelectedItem().toString();
        
        for(zgrafico_FAC_x_MES g: d.listgrafGAS_MES(met)){
            ds.setValue(g.getSuma(), "venta", g.getMes());
        }
        JFreeChart gf=ChartFactory.createBarChart3D("MES ","Mes", "MONTO", ds);
        ChartPanel cp = new ChartPanel(gf);
        gra.Panel.removeAll();
        gra.Panel.setLayout(new java.awt.BorderLayout());
        gra.Panel.add(cp,BorderLayout.CENTER);
        gra.Panel.validate();
    }
        
        
        
    void barramesPRO(){
        DefaultCategoryDataset ds=new DefaultCategoryDataset();
        String met = gra.CB_anio.getSelectedItem().toString();
        
        for(zgrafico_FAC_x_MES g: d.listgrafPRO_MES(met)){
            ds.setValue(g.getSuma(), "venta", g.getMes());
        }
        JFreeChart gf=ChartFactory.createBarChart3D("MES ","Mes", "MONTO", ds);
        ChartPanel cp = new ChartPanel(gf);
        gra.Panel.removeAll();
        gra.Panel.setLayout(new java.awt.BorderLayout());
        gra.Panel.add(cp,BorderLayout.CENTER);
        gra.Panel.validate();
    }
    
    
    DecimalFormat sd=new DecimalFormat("0.00");
    
    void tortaPIZ(){
    DefaultPieDataset ds=new DefaultPieDataset(); 
    String met = gra.CB_anio.getSelectedItem().toString();
    
    double sm=0;
    for(zgrafico_FAC_x_MES x:d.listgrafPIZ_MES(met))sm=sm+x.getSuma();
     
     double porc;
     for(zgrafico_FAC_x_MES  x:d.listgrafPIZ_MES(met)){
         porc=(x.getSuma()/sm)*100;
         ds.setValue(x.getMes()+"-"+sd.format(porc)+"%", x.getSuma());
     } 
     //graficar en memoria
     JFreeChart gf=ChartFactory.createPieChart3D("PIZZAS ", ds);
   
      ChartPanel cp=new ChartPanel(gf);
      gra.Panel.removeAll();
      gra.Panel.setLayout(new java.awt.BorderLayout());
      gra.Panel.add(cp,BorderLayout.CENTER);
      gra.Panel.validate();
    }
    
    
    
    void tortaGAS(){
    DefaultPieDataset ds=new DefaultPieDataset(); 
    String met = gra.CB_anio.getSelectedItem().toString();
    
    double sm=0;
    for(zgrafico_FAC_x_MES x:d.listgrafGAS_MES(met))sm=sm+x.getSuma();
     
     double porc;
     for(zgrafico_FAC_x_MES  x:d.listgrafGAS_MES(met)){
         porc=(x.getSuma()/sm)*100;
         ds.setValue(x.getMes()+"-"+sd.format(porc)+"%", x.getSuma());
     } 
     //graficar en memoria
     JFreeChart gf=ChartFactory.createPieChart3D("PIZZAS ", ds);
   
      ChartPanel cp=new ChartPanel(gf);
      gra.Panel.removeAll();
      gra.Panel.setLayout(new java.awt.BorderLayout());
      gra.Panel.add(cp,BorderLayout.CENTER);
      gra.Panel.validate();
    }
        
        
        
        
    void tortaPRO(){
    DefaultPieDataset ds=new DefaultPieDataset(); 
    String met = gra.CB_anio.getSelectedItem().toString();
    
    double sm=0;
    for(zgrafico_FAC_x_MES x:d.listgrafPRO_MES(met))sm=sm+x.getSuma();
     
     double porc;
     for(zgrafico_FAC_x_MES  x:d.listgrafPRO_MES(met)){
         porc=(x.getSuma()/sm)*100;
         ds.setValue(x.getMes()+"-"+sd.format(porc)+"%", x.getSuma());
     } 
     //graficar en memoria
     JFreeChart gf=ChartFactory.createPieChart3D("PIZZAS ", ds);
   
      ChartPanel cp=new ChartPanel(gf);
      gra.Panel.removeAll();
      gra.Panel.setLayout(new java.awt.BorderLayout());
      gra.Panel.add(cp,BorderLayout.CENTER);
      gra.Panel.validate();
    }    
    
    
    
    void lineaPIZ(){
        DefaultCategoryDataset ds=new DefaultCategoryDataset();
        String met = gra.CB_anio.getSelectedItem().toString();
        for(zgrafico_FAC_x_MES x: d.listgrafPIZ_MES(met)){
            ds.setValue(x.getSuma(), "ventas", x.getMes());
            
        }
        JFreeChart gf=ChartFactory.createLineChart("SALA ","Sala", "MONTO", ds);
        ChartPanel cp=new ChartPanel(gf);
        gra.Panel.removeAll();
        gra.Panel.setLayout(new java.awt.BorderLayout());
        gra.Panel.add(cp,BorderLayout.CENTER);
        gra.Panel.validate();
    }
    
    void lineaGAS(){
        DefaultCategoryDataset ds=new DefaultCategoryDataset();
        String met = gra.CB_anio.getSelectedItem().toString();
        for(zgrafico_FAC_x_MES x: d.listgrafGAS_MES(met)){
            ds.setValue(x.getSuma(), "ventas", x.getMes());
            
        }
        JFreeChart gf=ChartFactory.createLineChart("SALA ","Sala", "MONTO", ds);
        ChartPanel cp=new ChartPanel(gf);
        gra.Panel.removeAll();
        gra.Panel.setLayout(new java.awt.BorderLayout());
        gra.Panel.add(cp,BorderLayout.CENTER);
        gra.Panel.validate();
    }


    void lineaPRO(){
        DefaultCategoryDataset ds=new DefaultCategoryDataset();
        String met = gra.CB_anio.getSelectedItem().toString();
        for(zgrafico_FAC_x_MES x: d.listgrafPRO_MES(met)){
            ds.setValue(x.getSuma(), "ventas", x.getMes());
            
        }
        JFreeChart gf=ChartFactory.createLineChart("SALA ","Sala", "MONTO", ds);
        ChartPanel cp=new ChartPanel(gf);
        gra.Panel.removeAll();
        gra.Panel.setLayout(new java.awt.BorderLayout());
        gra.Panel.add(cp,BorderLayout.CENTER);
        gra.Panel.validate();
    }
    
    void botonbarra(){
        switch (gra.CB_variable.getSelectedIndex()) {
            case 0:
                barramesPIZ();
                break;
            case 1:
                barramesGAS();
                break;
            case 2:
                barramesPRO();
                break;
            default:
                gra.Panel.removeAll();
                gra.Panel.repaint();
                break;
        }
        boton = 2;
    }
    
    
    void botontorta(){
        switch (gra.CB_variable.getSelectedIndex()) {
            case 0:
                tortaPIZ();
                break;
            case 1:
                tortaGAS();
                break;
            case 2:
                tortaPRO();
                break;
            default:
                gra.Panel.removeAll();
                gra.Panel.repaint();
                break;
        }
        boton = 1;
    }    
    
    void botonlinea(){
        switch (gra.CB_variable.getSelectedIndex()) {
            case 0:
                lineaPIZ();
                break;
            case 1:
                lineaGAS();
                break;
            case 2:
                lineaPRO();
                break;
            default:
                gra.CB_variable.removeAll();
                gra.CB_variable.repaint();
                boton = 0;
                break;
        }
        boton = 3;
    }    

    @Override
    public void actionPerformed(ActionEvent e) {

        
        if(e.getSource() == gra.CB_variable){
            switch (gra.CB_variable.getSelectedIndex()) {
            case 0:
                verTB_F_M_PIZ();
                break;
            case 1:
                verTB_F_M_GAS();
                break;
            case 2:
                verTB_F_M_PRO();
                break;
            default:
                DefaultTableModel dt = (DefaultTableModel)gra.TB_mostrar_variable.getModel();
                dt.setRowCount(0);
                break;
            }
            
        }
        
        if(e.getSource() == gra.btn_mes){
            botonbarra();
            
        }
        
        if(e.getSource() == gra.btn_torta){
            botontorta();            
        }
        
        if(e.getSource() == gra.btn_linea){
            botonlinea();            
        }
        

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
