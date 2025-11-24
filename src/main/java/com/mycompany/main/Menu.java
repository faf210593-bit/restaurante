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
public class Menu {
    private List<Producto> productos;

    public Menu() {
        productos = new ArrayList<>();

        Producto pollo = new Producto("Pollo a la brasa");
        pollo.agregarOpcion("1/4 de Pollo", 15.0);
        pollo.agregarOpcion("1/2 Pollo", 25.0);
        pollo.agregarOpcion("Pollo entero", 45.0);

        Producto papas = new Producto("Papas fritas");
        papas.agregarOpcion("Para uno", 7.0);
        papas.agregarOpcion("Para 5", 18.0);
        papas.agregarOpcion("Familiar", 25.0);

        Producto bebida = new Producto("Inka Kola");
        bebida.agregarOpcion("Personal", 5.0);
        bebida.agregarOpcion("Litro", 10.0);
        bebida.agregarOpcion("2 litros", 15.0);

        agregarProducto(pollo);
        agregarProducto(papas);
        agregarProducto(bebida);
    }

    public void mostrarMenu() {
        System.out.println("------ MENÚ ------");
        for (Producto p : productos) {
            System.out.println(p.id + ". " + p.nombre);
        }
    }

    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.id == id) return p;
        }
        return null;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }
}