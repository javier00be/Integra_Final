/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_REF;

/**
 *
 * @author sebas
 */
public class gaseosas {
    private String cod_gaseosa;
    private String descripcion;
    private String imagen;
    private String marca;
    private double precio;
    private String tamaño;
    private int stock;

    public gaseosas(String cod_gaseosa, String descripcion, String imagen, String marca, double precio, String tamaño, int stock) {
        this.cod_gaseosa = cod_gaseosa;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.marca = marca;
        this.precio = precio;
        this.tamaño = tamaño;
        this.stock = stock;
    }
    
    public String getCod_gaseosa() {
        return cod_gaseosa;
    }

    public void setCod_gaseosa(String cod_gaseosa) {
        this.cod_gaseosa = cod_gaseosa;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
