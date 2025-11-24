/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FERNANDO
 */
public class Producto {
    private static int contadorId = 1;
    public int id;
    public String nombre;
    public List<OpcionProducto> opciones;

    public Producto(String nombre) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.opciones = new ArrayList<>();
    }

    public void agregarOpcion(String descripcion, double precio) {
        opciones.add(new OpcionProducto(descripcion, precio));
    }

    public void agregarOpcion(OpcionProducto op) {
        opciones.add(op);
    }

    public int getId() {
        return id;
    }
}