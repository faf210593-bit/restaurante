/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Fernando
 */
public class Pedidos {
    private int id;
    private List<ItemPedido> items;
    private String estado;

    public Pedidos(int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.estado = "pendiente";
    }

    public void agregarItem(ItemPedido item) {
        items.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : items) {
            total += item.getPrecio();
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
