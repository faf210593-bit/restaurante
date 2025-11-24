/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FERNANDO
 */
public class SistemaPedidos {
    public Menu menu;
    private List<Pedido> pedidos;
    private int contadorPedidos;

    public SistemaPedidos() {
        menu = new Menu();
        pedidos = new ArrayList<>();
        contadorPedidos = 1;
    }

    public void mostrarMenu() {
        menu.mostrarMenu();
    }

    public void tomarPedido(Scanner sc) {
        Pedido pedido = new Pedido(contadorPedidos++);
        int productosAgregados = 0;

        while (true) {
            mostrarMenu();
            System.out.print("Ingrese ID del producto (0 para terminar, admin para administración): ");
            String entrada = sc.nextLine().trim();

            if (entrada.equals("0")) break;
            if (entrada.equalsIgnoreCase("admin")) {
                System.out.println("Regresando al menú principal para acceso administrador...");
                contadorPedidos--; // no se consume el ID
                return;
            }

            int id;
            try {
                id = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Intente nuevamente.");
                continue;
            }

            Producto producto = menu.buscarPorId(id);
            if (producto == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            if (producto.opciones.isEmpty()) {
                System.out.println("Este producto no tiene opciones disponibles.");
                continue;
            }

            System.out.println("Opciones para " + producto.nombre + ":");
            for (int i = 0; i < producto.opciones.size(); i++) {
                OpcionProducto op = producto.opciones.get(i);
                System.out.println((i + 1) + ". " + op.descripcion + " - S/" + op.precio);
            }

            System.out.print("Seleccione una opción: ");
            int opcionSeleccionada;
            try {
                opcionSeleccionada = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida.");
                continue;
            }

            if (opcionSeleccionada < 1 || opcionSeleccionada > producto.opciones.size()) {
                System.out.println("Opción fuera de rango.");
                continue;
            }

            OpcionProducto seleccionada = producto.opciones.get(opcionSeleccionada - 1);
            pedido.agregarItem(new ItemPedido(producto.nombre, seleccionada.descripcion, seleccionada.precio));
            productosAgregados++;

            System.out.println(productosAgregados == 1 ? "Producto agregado." : "Productos agregados.");
        }

        if (productosAgregados > 0) {
            pedidos.add(pedido);
            System.out.println("Pedido #" + pedido.getId() + " registrado correctamente. Total: S/" + pedido.calcularTotal());
        } else {
            System.out.println("No se agregó ningún producto. Pedido cancelado.");
            contadorPedidos--; // se recupera el ID porque no se usó
        }
    }

    public void verPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }

        for (Pedido pedido : pedidos) {
            System.out.println("\nPedido #" + pedido.getId());
            for (ItemPedido item : pedido.getItems()) {
                System.out.println("- " + item.getNombreProducto() + " (" + item.getDescripcionOpcion() + ") - S/" + item.getPrecio());
            }
            System.out.println("Total: S/" + pedido.calcularTotal());
            System.out.println("Estado: " + pedido.getEstado());
        }
    }

    public void actualizarEstado(Scanner sc) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos para actualizar.");
            return;
        }

        verPedidos();
        System.out.print("Ingrese el ID del pedido a actualizar: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return;
        }

        Pedido pedido = null;
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                pedido = p;
                break;
            }
        }

        if (pedido == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }

        System.out.print("Ingrese nuevo estado (pendiente / en preparación / entregado): ");
        String nuevoEstado = sc.nextLine().trim();
        pedido.setEstado(nuevoEstado);
        System.out.println("Estado actualizado correctamente.");
    }

    public void agregarProducto(Scanner sc) {
        System.out.print("Ingrese nombre del nuevo producto: ");
        String nombre = sc.nextLine();
        Producto producto = new Producto(nombre);

        while (true) {
            System.out.print("Ingrese descripción de la opción (o 'fin' para terminar): ");
            String descripcion = sc.nextLine();
            if (descripcion.equalsIgnoreCase("fin")) break;

            System.out.print("Ingrese precio: ");
            double precio;
            try {
                precio = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido.");
                continue;
            }

            producto.agregarOpcion(new OpcionProducto(descripcion, precio));
        }

        menu.agregarProducto(producto);
        System.out.println("Producto agregado al menú.");
    }

    public void eliminarProducto(Scanner sc) {
        mostrarMenu();
        System.out.print("Ingrese ID del producto a eliminar: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return;
        }

        Producto producto = menu.buscarPorId(id);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        menu.eliminarProducto(producto);
        System.out.println("Producto eliminado del menú.");
    }

    public void modificarProducto(Scanner sc) {
        mostrarMenu();
        System.out.print("Ingrese ID del producto a modificar: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return;
        }

        Producto producto = menu.buscarPorId(id);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Ingrese nuevo nombre (dejar vacío para mantener el actual): ");
        String nuevoNombre = sc.nextLine();
        if (!nuevoNombre.trim().isEmpty()) {
            producto.nombre = nuevoNombre;
        }

        System.out.println("Opciones actuales:");
        for (int i = 0; i < producto.opciones.size(); i++) {
            OpcionProducto op = producto.opciones.get(i);
            System.out.println((i + 1) + ". " + op.descripcion + " - S/" + op.precio);
        }

        System.out.print("¿Desea modificar opciones? (s/n): ");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            producto.opciones.clear();
            while (true) {
                System.out.print("Ingrese nueva opción (o 'fin' para terminar): ");
                String desc = sc.nextLine();
                if (desc.equalsIgnoreCase("fin")) break;

                System.out.print("Ingrese precio: ");
                double precio;
                try {
                    precio = Double.parseDouble(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Precio inválido.");
                    continue;
                }

                producto.agregarOpcion(new OpcionProducto(desc, precio));
            }
        }

        System.out.println("Producto modificado.");
    }
}