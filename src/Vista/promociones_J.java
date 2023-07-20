/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import DAO.dao;
import Modelo_REF.*;
import javax.swing.DefaultListModel;
/**
 *
 * @author W10
 */
public class promociones_J extends javax.swing.JFrame {

    
    dao obj=new dao();
    DefaultListModel<String> modelgas=new DefaultListModel<>();
    DefaultListModel<String> modelpizz=new DefaultListModel<>();
    DefaultListModel<String> modelprom=new DefaultListModel<>();
    
    private void updatelist(){
        modelgas.clear();
        modelpizz.clear();
        modelprom.clear();
        
        listgaseosa.setModel(modelgas);
        listpizza.setModel(modelpizz);
        listapromociones.setModel(modelprom);
        for(gaseosas gas : obj.lisgaseosas()){
            String x=gas.getMarca();
            String y=gas.getCod_gaseosa();
            String z=y+" - "+x;
            modelgas.addElement(z);
        }
        for(pizza p : obj.lispizza()){
            String x=p.getDetalle();
            String y=p.getCod_pizza();
            String z=y+" - "+x;
            modelpizz.addElement(z);
        }
        for(promocion_pizza x : obj.lispromo()){
            double a = x.getPrecio();
            String y=x.getCod_prom();
            String b=x.getNombre();
            String z=y+" - "+b+" - "+a;
            modelprom.addElement(z);
        } 
    }
    
    private void crearprom(String nombreprom, String idpizza, int cantpizza, String idgaseosa, int cantgaseosa){
        
        pizza p=obj.buspizza(idpizza);
        gaseosas g=obj.busgaseosas(idgaseosa);
        double precio_pizza=p.getPrecio();
        double precio_gaseosa=g.getPrecio();
        double precio_total=precio_pizza*cantpizza+precio_gaseosa*cantgaseosa;
        promocion_pizza prom=new promocion_pizza(cantgaseosa, cantpizza, g, "", nombreprom, p, precio_total);
        obj.addpromociones(prom);
    }

    /**
     * Creates new form promociones
     */
    public promociones_J() {
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listpizza = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listgaseosa = new javax.swing.JList<>();
        cantgaseosa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cantpizza = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botoncrear = new javax.swing.JButton();
        botoneliminar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listapromociones = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nombpromo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(listpizza);

        jScrollPane2.setViewportView(listgaseosa);

        cantgaseosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantgaseosaActionPerformed(evt);
            }
        });

        jLabel1.setText("NOMBRE DE LA PROMOCIÓN");

        jLabel2.setText("CANTIDAD DE PIZZA");

        jLabel3.setText("GASEOSA");

        jLabel4.setText("PIZZA");

        jLabel5.setText("PROMOCIONES ACTIVAS");

        botoncrear.setText("CREAR PROMOCIÓN");
        botoncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncrearActionPerformed(evt);
            }
        });

        botoneliminar.setText("ELIMINAR PROMOCIÓN");
        botoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(listapromociones);

        jButton1.setText("ACTUALIZAR LISTAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("CANTIDAD DE GASEOSA");

        nombpromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombpromoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(cantpizza, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nombpromo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cantgaseosa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(botoneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botoncrear, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(243, 243, 243))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel5)
                .addGap(264, 264, 264)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(141, 141, 141))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombpromo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cantgaseosa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantpizza, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botoneliminar)
                        .addGap(47, 47, 47)
                        .addComponent(botoncrear)
                        .addGap(101, 101, 101))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        updatelist();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cantgaseosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantgaseosaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantgaseosaActionPerformed

    private void botoncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncrearActionPerformed
        // TODO add your handling code here:
        String nompro=nombpromo.getText();
        String gas=listgaseosa.getSelectedValue();
        String pgas = gas.substring(0, 5);
        String pizz=listpizza.getSelectedValue();
        String ppizz = pizz.substring(0, 5);
        int cantgas=Integer.parseInt(cantgaseosa.getText());
        int cantpizz=Integer.parseInt(cantpizza.getText());

        crearprom(nompro, ppizz, cantpizz, pgas, cantgas);
        
        nombpromo.setText("");
        cantgaseosa.setText("");
        cantpizza.setText("");
        
        modelprom.clear();
        listapromociones.setModel(modelprom);
    }//GEN-LAST:event_botoncrearActionPerformed

    private void nombpromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombpromoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombpromoActionPerformed

    private void botoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarActionPerformed
        // TODO add your handling code here:
        String id=listapromociones.getSelectedValue();
        String pid = id.substring(0, 5);
        obj.delprom(pid);

        nombpromo.setText("");
        cantgaseosa.setText("");
        cantpizza.setText("");
        
        
        modelprom.clear();
        listapromociones.setModel(modelprom);
    }//GEN-LAST:event_botoneliminarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(promociones_J.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(promociones_J.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(promociones_J.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(promociones_J.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//
//        
//
//        
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new promociones_J().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoncrear;
    private javax.swing.JButton botoneliminar;
    private javax.swing.JTextField cantgaseosa;
    private javax.swing.JTextField cantpizza;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listapromociones;
    private javax.swing.JList<String> listgaseosa;
    private javax.swing.JList<String> listpizza;
    private javax.swing.JTextField nombpromo;
    // End of variables declaration//GEN-END:variables
}
