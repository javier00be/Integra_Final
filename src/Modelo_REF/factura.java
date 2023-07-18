/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_REF;

/**
 *
 * @author sebas
 */
public class factura {
    private String cod_fac;
    private String fecha;
    private double pago;
    private metodo_pago met;
    private orden ord;

    public factura() {
    }

    public String getCod_fac() {
        return cod_fac;
    }

    public void setCod_fac(String cod_fac) {
        this.cod_fac = cod_fac;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public metodo_pago getMet() {
        return met;
    }

    public void setMet(metodo_pago met) {
        this.met = met;
    }

    public orden getOrd() {
        return ord;
    }

    public void setOrd(orden ord) {
        this.ord = ord;
    }
    
    
}
