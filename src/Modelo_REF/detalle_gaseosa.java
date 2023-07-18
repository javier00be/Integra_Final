/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_REF;

/**
 *
 * @author sebas
 */
public class detalle_gaseosa {
    private orden ord;
    private gaseosas gas;
    private int cantidad;
    private double precio;

    public detalle_gaseosa(orden ord, gaseosas gas, int cantidad, double precio) {
        this.ord = ord;
        this.gas = gas;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public orden getOrd() {
        return ord;
    }

    public void setOrd(orden ord) {
        this.ord = ord;
    }

    public gaseosas getGas() {
        return gas;
    }

    public void setGas(gaseosas gas) {
        this.gas = gas;
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
