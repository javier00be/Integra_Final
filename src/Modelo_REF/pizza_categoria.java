/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_REF;

/**
 *
 * @author sebas
 */
public class pizza_categoria {
    private String cod_cate;
    private String descripcion;
    private String imagen;
    private String nombre;

    /////////////////////////////////////////////////////////CONSTRUCTOR////////////////////////////////
    public pizza_categoria() {
    }

    /////////////////////////////////////////////////////////GETTERS ANS SETTERS////////////////////////////////
    public String getCod_cate() {
        return cod_cate;
    }

    public void setCod_cate(String cod_cate) {
        this.cod_cate = cod_cate;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
