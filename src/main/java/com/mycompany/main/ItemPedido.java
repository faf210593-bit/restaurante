/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author FERNANDO
 */
public class ItemPedido {
    private String nombreProducto;
    private String descripcionOpcion;
    private double precio;

    public ItemPedido(String nombreProducto, String descripcionOpcion, double precio) {
        this.nombreProducto = nombreProducto;
        this.descripcionOpcion = descripcionOpcion;
        this.precio = precio;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getDescripcionOpcion() {
        return descripcionOpcion;
    }

    public double getPrecio() {
        return precio;
    }
}