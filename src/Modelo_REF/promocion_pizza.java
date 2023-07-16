/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_REF;

/**
 *
 * @author sebas
 */
public class promocion_pizza {
    private int cant_gaseosa;
    private int cant_pizza;
    private String cod_prom;
    private gaseosas gase;
    private String imagen;
    private String nombre;
    private pizza pizza;
    private double precio;

    public promocion_pizza() {
    }

    public int getCant_gaseosa() {
        return cant_gaseosa;
    }

    public void setCant_gaseosa(int cant_gaseosa) {
        this.cant_gaseosa = cant_gaseosa;
    }

    public int getCant_pizza() {
        return cant_pizza;
    }

    public void setCant_pizza(int cant_pizza) {
        this.cant_pizza = cant_pizza;
    }

    public String getCod_prom() {
        return cod_prom;
    }

    public void setCod_prom(String cod_prom) {
        this.cod_prom = cod_prom;
    }

    public gaseosas getGase() {
        return gase;
    }

    public void setGase(gaseosas gase) {
        this.gase = gase;
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

    public pizza getPizza() {
        return pizza;
    }

    public void setPizza(pizza pizza) {
        this.pizza = pizza;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
