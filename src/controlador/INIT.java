/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.dao;
import Modelo_REF.*;

/**
 *
 * @author sebas
 */
public class INIT {
    
    public static void main (String[] args){
        dao d = new dao();
        usuario usu = d.bususuario(1);//obj.bususuario(1)
        Controlador_Empleado empleado = new Controlador_Empleado();
    }

}
