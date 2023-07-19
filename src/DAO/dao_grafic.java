/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo_REF.*;
import Util.MySQLConexion;
import java.sql.*;
import java.util.*;

/**
 *
 * @author sebas
 */
public class dao_grafic {
    
    public List<zgrafico_FAC_x_MES> listgrafPIZ_MES(String anio) {
        List<zgrafico_FAC_x_MES> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String mes = "";
            String sql="{call obt_piz(?)}";
            CallableStatement st=cn.prepareCall(sql);
            st.setString(1, anio);
            st.executeUpdate();
            
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                zgrafico_FAC_x_MES d=new zgrafico_FAC_x_MES();
                
                d.setMes(rs.getString(1));
                d.setCantidad(rs.getInt(2));
                d.setSuma(rs.getDouble(3));
                lis.add(d);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;
    }
    
    
        public List<zgrafico_FAC_x_MES> listgrafGAS_MES(String anio) {
        List<zgrafico_FAC_x_MES> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="{call obt_gas(?)}";
            CallableStatement st=cn.prepareCall(sql);
            st.setString(1, anio);
            st.executeUpdate();
            
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                zgrafico_FAC_x_MES d=new zgrafico_FAC_x_MES();
                
                d.setMes(rs.getString(1));
                d.setCantidad(rs.getInt(2));
                d.setSuma(rs.getDouble(3));
                lis.add(d);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;
    }
        
        
        
        public List<zgrafico_FAC_x_MES> listgrafPRO_MES(String anio) {
        List<zgrafico_FAC_x_MES> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="{call obt_pro(?)}";
            CallableStatement st=cn.prepareCall(sql);
            st.setString(1, anio);
            st.executeUpdate();
            
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                zgrafico_FAC_x_MES d=new zgrafico_FAC_x_MES();
                
                d.setMes(rs.getString(1));
                d.setCantidad(rs.getInt(2));
                d.setSuma(rs.getDouble(3));
                lis.add(d);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;
    }
    
        public List<String> listgra() {
        List<String> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
            String sql="SELECT DISTINCT YEAR(o.fecha) AS ANIO FROM orden o;";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                String fe = rs.getString(1);
                lis.add(fe);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
          try{ cn.close();}catch(Exception ex2){}

        }
        return lis;
    }
    
}
