/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_REF;

/**
 *
 * @author sebas
 */
public class pizza {
    private String cod_pizza;
    private String detalle;
    private pizza_categoria cate;
    private double precio;
    private tamaño tam;
    private int stock;

    public pizza(String cod_pizza, String detalle, pizza_categoria cate, double precio, tamaño tam, int stock) {
        this.cod_pizza = cod_pizza;
        this.detalle = detalle;
        this.cate = cate;
        this.precio = precio;
        this.tam = tam;
        this.stock = stock;
    }
    
    

    public String getCod_pizza() {
        return cod_pizza;
    }

    public void setCod_pizza(String cod_pizza) {
        this.cod_pizza = cod_pizza;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public pizza_categoria getCate() {
        return cate;
    }

    public void setCate(pizza_categoria cate) {
        this.cate = cate;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public tamaño getTam() {
        return tam;
    }

    public void setTam(tamaño tam) {
        this.tam = tam;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
