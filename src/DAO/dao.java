/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo_REF.*;
import Util.MySQLConexion;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.*;
//import java.util.ArrayList;
//import java.util.List;

/**
 *
 * @author sebas
 */
public class dao {
    
    public List<tamaño> listam() {
        List<tamaño> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from tamano";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                tamaño a=new tamaño();
                a.setCod_Tam(rs.getInt(1));
                a.setNombre(rs.getString(2));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;    
    }
    
    
    public tamaño bustam(int cod) {
        List<tamaño> lis=new ArrayList();
        tamaño a = null;
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * FROM tamano where cod_Tam=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, cod);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                a=new tamaño();
                a.setCod_Tam(rs.getInt(1));
                a.setNombre(rs.getString(2));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return a;    
    }
        
        
    public List<pizza_categoria> liscat() {
        List<pizza_categoria> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from pizza_categoria";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                pizza_categoria a=new pizza_categoria();
                a.setCod_cate(rs.getString(1));
                a.setNombre(rs.getString(2));
                a.setImagen(rs.getString(3));
                a.setDescripcion(rs.getString(4));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;    
    }     

    public pizza_categoria buscat(String cod) {
        List<pizza_categoria> lis=new ArrayList();
        pizza_categoria a = null;
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * FROM pizza_categoria where cod_cate=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                a=new pizza_categoria();
                a.setCod_cate(rs.getString(1));
                a.setNombre(rs.getString(2));
                a.setImagen(rs.getString(3));
                a.setDescripcion(rs.getString(4));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return a;    
    }

    public List<pizza> lispizza(){
        List<pizza> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from pizza";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                pizza a=new pizza(rs.getString(1),rs.getString(2),buscat(rs.getString(4)),rs.getDouble(3),bustam(rs.getInt(5)),rs.getInt(6));
//                a.setCod_pizza(rs.getString(1));
//                a.setDetalle(rs.getString(2));
//                a.setPrecio(rs.getDouble(3));
//                a.setCate(buscat(rs.getString(4)));
//                a.setTam(bustam(rs.getInt(5)));
//                a.setStock(rs.getInt(6));                
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;  
    }

    public pizza buspizza(String cod) {
        List<pizza> lis=new ArrayList();
        pizza a = null;
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * FROM pizza where cod_pizza=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                a=new pizza(rs.getString(1),rs.getString(2),buscat(rs.getString(4)),rs.getDouble(3),bustam(rs.getInt(5)),rs.getInt(6));
//                a.setCod_pizza(rs.getString(1));
//                a.setDetalle(rs.getString(2));
//                a.setPrecio(rs.getDouble(3));
//                a.setCate(buscat(rs.getString(4)));
//                a.setTam(bustam(rs.getInt(5)));
//                a.setStock(rs.getInt(6));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return a;    
    }    
    
    
    
        public List<gaseosas> lisgaseosas(){
        List<gaseosas> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from gaseosa";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                gaseosas a=new gaseosas(rs.getString(1),rs.getString(5),rs.getString(6),rs.getString(2),rs.getDouble(4),rs.getString(3),rs.getInt(7));
//                a.setCod_gaseosa(rs.getString(1));
//                a.setMarca(rs.getString(2));
//                a.setTamaño(rs.getString(3));
//                a.setPrecio(rs.getDouble(4));
//                a.setDescripcion(rs.getString(5));
//                a.setImagen(rs.getString(6));
//                a.setStock(rs.getInt(7));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;  
    }
    
        
    public gaseosas busgaseosas(String cod) {
        List<gaseosas> lis=new ArrayList();
        gaseosas a = null;
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * FROM gaseosa where cod_gaseosa=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                a=new gaseosas(rs.getString(1),rs.getString(5),rs.getString(6),rs.getString(2),rs.getDouble(4),rs.getString(3),rs.getInt(7));
//                a.setCod_gaseosa(rs.getString(1));
//                a.setMarca(rs.getString(2));
//                a.setTamaño(rs.getString(3));
//                a.setPrecio(rs.getDouble(4));
//                a.setDescripcion(rs.getString(5));
//                a.setImagen(rs.getString(6));
//                a.setStock(rs.getInt(7));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return a;    
    }
    
    
    public List<promocion_pizza> lispromo(){
        List<promocion_pizza> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from promocion_pizza";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                promocion_pizza a=new promocion_pizza(rs.getInt(4),rs.getInt(3),rs.getString(1),busgaseosas(rs.getString(8)),rs.getString(5),rs.getString(2),buspizza(rs.getString(7)),rs.getDouble(6));
//                a.setCod_prom(rs.getString(1));
//                a.setNombre(rs.getString(2));
//                a.setCant_pizza(rs.getInt(3));
//                a.setCant_gaseosa(rs.getInt(4));
//                a.setImagen(rs.getString(5));
//                a.setPrecio(rs.getDouble(6));
//                a.setPizza(buspizza(rs.getString(7)));
//                a.setGase(busgaseosas(rs.getString(8)));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;  
    }

    public promocion_pizza buspromo(String cod) {
        List<promocion_pizza> lis=new ArrayList();
        promocion_pizza a = null;
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * FROM promocion_pizza where cod_prom=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                a=new promocion_pizza(rs.getInt(4),rs.getInt(3),rs.getString(1),busgaseosas(rs.getString(8)),rs.getString(5),rs.getString(2),buspizza(rs.getString(7)),rs.getDouble(6));
//                a.setCod_prom(rs.getString(1));
//                a.setNombre(rs.getString(2));
//                a.setCant_pizza(rs.getInt(3));
//                a.setCant_gaseosa(rs.getInt(4));
//                a.setImagen(rs.getString(5));
//                a.setPrecio(rs.getDouble(6));
//                a.setPizza(buspizza(rs.getString(7)));
//                a.setGase(busgaseosas(rs.getString(8)));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return a;    
    }
    
    public List<usuario> lisusuarios(){
        List<usuario> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from usuario";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                usuario a=new usuario();
                a.setCod_usu(rs.getInt(1));
                a.setNombre(rs.getString(2));                
                a.setCorreo(rs.getString(3));
                a.setContraseña(rs.getString(4));
                a.setRol(rs.getString(5));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;  
    }
    
    
        public usuario bususuario(int cod) {
        List<usuario> lis=new ArrayList();
        usuario a = null;
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from usuario where cod_usu=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, cod);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                a=new usuario();
                a.setCod_usu(rs.getInt(1));
                a.setNombre(rs.getString(2));                
                a.setCorreo(rs.getString(3));
                a.setContraseña(rs.getString(4));
                a.setRol(rs.getString(5));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return a;    
    }
        
        
    public usuario bususuario(String cod) {
        List<usuario> lis=new ArrayList();
        usuario a = null;
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from usuario where correo=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, cod);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                a=new usuario();
                a.setCod_usu(rs.getInt(1));
                a.setNombre(rs.getString(2));                
                a.setCorreo(rs.getString(3));
                a.setContraseña(rs.getString(4));
                a.setRol(rs.getString(5));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return a;    
    }
    
    public List<orden> lisorden() {
        List<orden> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from orden";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                orden a=new orden(rs.getInt(1),rs.getString(3),rs.getString(2),bususuario(rs.getInt(4)));
//                a.setCod_orden(rs.getInt(1));
//                a.setNombre(rs.getString(2));
//                a.setFecha(rs.getString(3));
//                a.setUsu(bususuario(rs.getInt(4)));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;    
    }
        
        
    public orden busorden(int cod) {
        List<orden> lis=new ArrayList();
        orden a = null;
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from orden where cod_orden=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, cod);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                a=new orden(rs.getInt(1),rs.getString(3),rs.getString(2),bususuario(rs.getInt(4)));
//                a.setCod_orden(rs.getInt(1));
//                a.setNombre(rs.getString(2));
//                a.setFecha(rs.getString(3));
//                a.setUsu(bususuario(rs.getInt(4)));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return a;
    }
     
    
    public List<detalle_pizza> lisdetallePiza() {
        List<detalle_pizza> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from detalle_pizza";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                detalle_pizza a=new detalle_pizza(busorden(rs.getInt(3)),buspizza(rs.getString(4)),rs.getInt(1),rs.getDouble(2));
//                a.setCantidad(rs.getInt(1));
//                a.setPago(rs.getDouble(2));
//                a.setOrd(busorden(rs.getInt(3)));
//                a.setPiz(buspizza(rs.getString(4)));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;    
    }
    
    public List<detalle_gaseosa> lisdetalleGas() {
        List<detalle_gaseosa> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from detalle_gaseosa";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                detalle_gaseosa a=new detalle_gaseosa(busorden(rs.getInt(3)),busgaseosas(rs.getString(4)),rs.getInt(1),rs.getDouble(2));
//                a.setCantidad(rs.getInt(1));
//                a.setPrecio(rs.getDouble(2));
//                a.setOrd(busorden(rs.getInt(3)));
//                a.setGas(busgaseosas(rs.getString(4)));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;    
    }
     
    public List<detalle_promocion> lisdetallePro() {
        List<detalle_promocion> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from detalle_promocion";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                detalle_promocion a=new detalle_promocion(busorden(rs.getInt(3)),buspromo(rs.getString(4)),rs.getInt(1),rs.getDouble(2));
//                a.setCantidad(rs.getInt(1));
//                a.setPrecio(rs.getDouble(2));
//                a.setOrd(busorden(rs.getInt(3)));
//                a.setProm(buspromo(rs.getString(4)));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;    
    }
    
    public List<metodo_pago> lismetodo() {
        List<metodo_pago> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from metodo_pago";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                metodo_pago a=new metodo_pago();
                a.setCod_met(rs.getInt(1));
                a.setTipo_pago(rs.getString(2));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;    
    }
    
    public metodo_pago busmetodo(int cod) {
        List<metodo_pago> lis=new ArrayList();
        metodo_pago a = null;
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from metodo_pago where cod_met=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, cod);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                a=new metodo_pago();
                a.setCod_met(rs.getInt(1));
                a.setTipo_pago(rs.getString(2));                
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return a;
    }
        
    
        public List<factura> lisfactura() {
        List<factura> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from factura";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                factura a=new factura();
                a.setCod_fac(rs.getString(1));
                a.setFecha(rs.getString(2));
                a.setPago(rs.getDouble(3));
                a.setMet(busmetodo(rs.getInt(4)));
                a.setOrd(busorden(rs.getInt(5)));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;    
    }
    public void addfactura(factura fac){
        Connection cn=MySQLConexion.getConexion();
        try {
            String sql = "{call nuevo_factura( ?, ?, ?, ?)}";
            CallableStatement st = cn.prepareCall(sql);
            //st.setString(1, fac.getCod_fac());
            st.setString(1, fac.getFecha());
            st.setDouble(2, fac.getPago());            
            st.setInt(3, fac.getMet().getCod_met());
            st.setInt(4, fac.getOrd().getCod_orden());
            st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { cn.close(); } catch (Exception ex2) {
            }
        }
        
    }    
    
    public void addorden(orden ord){
        Connection cn=MySQLConexion.getConexion();
        try {
            String sql = "INSERT INTO orden (cod_orden, Nobre, fecha, usuario_cod_usu) VALUES (?, ?, ?, ?)";
            CallableStatement st = cn.prepareCall(sql);
            st.setInt(1, ord.getCod_orden());
            st.setString(2, ord.getFecha());
            st.setString(3, ord.getNombre());            
            st.setInt(4, ord.getUsu().getCod_usu());
            st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { cn.close(); } catch (Exception ex2) {
            }
        }
        
    }
    
    
    
    public void addlisdetallePiza(detalle_pizza dp){
        Connection cn=MySQLConexion.getConexion();
        try {
            String sql = "INSERT INTO detalle_pizza (cantidad, precio, Orden_cod_orden, Pizza_cod_pizza) VALUES (?, ?, ?, ?)";
            CallableStatement st = cn.prepareCall(sql);
            st.setInt(1, dp.getCantidad());
            st.setDouble(2, dp.getPago());
            st.setInt(3, dp.getOrd().getCod_orden());
            st.setString(4, dp.getPiz().getCod_pizza());
            st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { cn.close(); } catch (Exception ex2) {
            }
        }
        
    }
    
    public void addlisdetalleGase(detalle_gaseosa dg){
        Connection cn=MySQLConexion.getConexion();
        try {
            String sql = "INSERT INTO detalle_gaseosa (cantidad, precio, Orden_cod_orden, gaseosa_cod_gaseosa) VALUES (?, ?, ?, ?)";
            CallableStatement st = cn.prepareCall(sql);
            st.setInt(1, dg.getCantidad());
            st.setDouble(2, dg.getPrecio());
            st.setInt(3, dg.getOrd().getCod_orden());
            st.setString(4, dg.getGas().getCod_gaseosa());
            st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { cn.close(); } catch (Exception ex2) {
            }
        }
        
    }    
    
    
    public void addlisdetallePromo(detalle_promocion dg){
        Connection cn=MySQLConexion.getConexion();
        try {
            String sql = "INSERT INTO detalle_promocion (canttidad, precio, Orden_cod_orden, promocion_pizza_cod_prom) VALUES (?, ?, ?, ?)";
            CallableStatement st = cn.prepareCall(sql);
            st.setInt(1, dg.getCantidad());
            st.setDouble(2, dg.getPrecio());
            st.setInt(3, dg.getOrd().getCod_orden());
            st.setString(4, dg.getProm().getCod_prom());
            st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { cn.close(); } catch (Exception ex2) {
            }
        }
        
    }
    

    public orden utimo(usuario usu, String name, String fecha){

        orden a = null;
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select cod_orden from orden ORDER BY cod_orden DESC LIMIT 1";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                a=new orden(rs.getInt(1)+1,name,fecha,usu);
//                a.setCod_orden(rs.getInt(1)+1);
//                a.setNombre(name);
//                a.setFecha(fecha);
//                a.setUsu(usu);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return a;
    } 
     
    
    public int utimo(){
        int a = 0;
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select MAX(cod_orden) from orden";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                a = rs.getInt(1);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return a;
    }
    
    
    public void modSTOCK_PIZ(detalle_pizza detP){
        Connection cn=MySQLConexion.getConexion();
        pizza piz =  buspizza(detP.getPiz().getCod_pizza());
        int stock = 0;
        
        stock = piz.getStock() - detP.getCantidad() ;
        try{
            String sql="UPDATE pizza SET stock = ? WHERE cod_pizza ='"+piz.getCod_pizza()+"'";/*detP.getPiz().getCod_pizza()*/
            PreparedStatement st=cn.prepareStatement(sql);

            st.setInt(1, stock);
            st.executeUpdate();
                
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}
        }
    }
    
    
    public void modSTOCK_GAS(detalle_gaseosa detG){
        Connection cn=MySQLConexion.getConexion();
        gaseosas gas =  busgaseosas(detG.getGas().getCod_gaseosa());
        int stock = 0;
        
        stock = gas.getStock() - detG.getCantidad() ;
        try{
            String sql="UPDATE gaseosa SET stock = ? WHERE cod_gaseosa ='"+gas.getCod_gaseosa()+"'";/*detP.getPiz().getCod_pizza()*/
            PreparedStatement st=cn.prepareStatement(sql);

            st.setInt(1, stock);
            st.executeUpdate();
                
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}
        }
    }
    
    
    public void modSTOCK_PRO_P(detalle_promocion detR){
        Connection cn=MySQLConexion.getConexion();
        promocion_pizza pro =  buspromo(detR.getProm().getCod_prom());
        pizza piz =  buspizza(detR.getProm().getPizza().getCod_pizza());
        
        int stockP = 0;
        
        stockP = piz.getStock() - (detR.getCantidad() * detR.getProm().getCant_pizza()) ;
        try{
            String sql="UPDATE pizza SET stock = ? WHERE cod_pizza ='"+piz.getCod_pizza()+"'";/*detP.getPiz().getCod_pizza()*/
            PreparedStatement st=cn.prepareStatement(sql);

            st.setInt(1, stockP);
            st.executeUpdate();
                
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}
        }
    }
    
    
    public void modSTOCK_PRO_G(detalle_promocion detR){
        Connection cn=MySQLConexion.getConexion();
        promocion_pizza pro =  buspromo(detR.getProm().getCod_prom());
        gaseosas gas =  busgaseosas(detR.getProm().getGase().getCod_gaseosa());
        
        int stockG = 0;
        
        stockG = gas.getStock() - (detR.getCantidad() *detR.getProm().getCant_gaseosa());
        try{
            String sql="UPDATE gaseosa SET stock = ? WHERE cod_gaseosa ='"+gas.getCod_gaseosa()+"'";/*detP.getPiz().getCod_pizza()*/
            PreparedStatement st=cn.prepareStatement(sql);

            st.setInt(1, stockG);
            st.executeUpdate();
                
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}
        }
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public boolean delprom(String id) {
        Connection cn=MySQLConexion.getConexion();
        try {
            String sql = "DELETE FROM promocion_pizza WHERE cod_prom = '"+id+"'";
            PreparedStatement st = cn.prepareStatement(sql);
//            st.setString(1, id);
            st.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    
    public void addpromociones(promocion_pizza prom){
        Connection cn=MySQLConexion.getConexion();
        pizza pizz=prom.getPizza();
        gaseosas gas=prom.getGase();
        try {
            String sql = "call nuevo_promocion_pizza (?, ?, ?, ?, ?, ?, ?)";
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, prom.getNombre());
            st.setInt(2, prom.getCant_pizza());
            st.setInt(3, prom.getCant_gaseosa());
            st.setString(4, prom.getImagen());
            st.setDouble(5, prom.getPrecio());
            st.setString(6, pizz.getCod_pizza());
            st.setString(7, gas.getCod_gaseosa());
            st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { cn.close(); } catch (Exception ex2) {
            }
        }
        
    }
}
