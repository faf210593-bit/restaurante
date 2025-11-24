/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author FERNANDO
 */
public class DetallePedido {
    public Producto producto;
    public OpcionProducto opcion;
    public int cantidad;

    public DetallePedido(Producto producto, OpcionProducto opcion, int cantidad) {
        this.producto = producto;
        this.opcion = opcion;
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return opcion.precio * cantidad;
    }
}