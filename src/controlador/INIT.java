/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo_REF.*;

/**
 *
 * @author sebas
 */
public class INIT {
    
    public static void main (String[] args){
        usuario usu = new usuario();
        Controlador_Empleado empleado = new Controlador_Empleado(usu);                   
    }

}
