/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_REF;

/**
 *
 * @author sebas
 */
public class orden {
    private int cod_orden;
    private String fecha;
    private String nombre;
    private usuario usu;

    public orden() {
    }

    public int getCod_orden() {
        return cod_orden;
    }

    public void setCod_orden(int cod_orden) {
        this.cod_orden = cod_orden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public usuario getUsu() {
        return usu;
    }

    public void setUsu(usuario usu) {
        this.usu = usu;
    }
    
    
}
