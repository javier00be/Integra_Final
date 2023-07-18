/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_REF;

/**
 *
 * @author sebas
 */
public class detalle_promocion {
    private orden ord;
    private promocion_pizza prom;
    private int cantidad;
    private double precio;  

    public detalle_promocion(orden ord, promocion_pizza prom, int cantidad, double precio) {
        this.ord = ord;
        this.prom = prom;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public orden getOrd() {
        return ord;
    }

    public void setOrd(orden ord) {
        this.ord = ord;
    }

    public promocion_pizza getProm() {
        return prom;
    }

    public void setProm(promocion_pizza prom) {
        this.prom = prom;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
