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
                pizza a=new pizza();
                a.setCod_pizza(rs.getString(1));
                a.setDetalle(rs.getString(2));
                a.setPrecio(rs.getDouble(3));
                a.setCate(buscat(rs.getString(4)));
                a.setTam(bustam(rs.getInt(5)));
                
                
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
                a=new pizza();
                a.setCod_pizza(rs.getString(1));
                a.setDetalle(rs.getString(2));
                a.setPrecio(rs.getDouble(3));
                a.setCate(buscat(rs.getString(4)));
                a.setTam(bustam(rs.getInt(5)));
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
                gaseosas a=new gaseosas();
                a.setCod_gaseosa(rs.getString(1));
                a.setMarca(rs.getString(2));
                a.setTamaño(rs.getString(3));
                a.setPrecio(rs.getDouble(4));
                a.setDescripcion(rs.getString(5));
                a.setImagen(rs.getString(6));
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
                a=new gaseosas();
                a.setCod_gaseosa(rs.getString(1));
                a.setMarca(rs.getString(2));
                a.setTamaño(rs.getString(3));
                a.setPrecio(rs.getDouble(4));
                a.setDescripcion(rs.getString(5));
                a.setImagen(rs.getString(6));
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
                promocion_pizza a=new promocion_pizza();
                a.setCod_prom(rs.getString(1));
                a.setNombre(rs.getString(2));
                a.setCant_pizza(rs.getInt(3));
                a.setCant_gaseosa(rs.getInt(4));
                a.setImagen(rs.getString(5));
                a.setPrecio(rs.getDouble(6));
                a.setPizza(buspizza(rs.getString(7)));
                a.setGase(busgaseosas(rs.getString(8)));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;  
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
    
        public List<orden> lisorden() {
        List<orden> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="select * from orden";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                orden a=new orden();
                a.setCod_orden(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setFecha(rs.getString(3));
                a.setUsu(bususuario(rs.getInt(4)));
                lis.add(a);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;    
    }
        
        
}
