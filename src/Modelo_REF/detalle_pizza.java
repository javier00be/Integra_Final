/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_REF;

/**
 *
 * @author sebas
 */
public class detalle_pizza {
    private orden ord;    
    private pizza piz;
    private int cantidad;
    private double pago;

    public detalle_pizza(orden ord, pizza piz, int cantidad, double pago) {
        this.ord = ord;
        this.piz = piz;
        this.cantidad = cantidad;
        this.pago = pago;
    }
    
    

    public orden getOrd() {
        return ord;
    }

    public void setOrd(orden ord) {
        this.ord = ord;
    }

    public pizza getPiz() {
        return piz;
    }

    public void setPiz(pizza piz) {
        this.piz = piz;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }
    
}
