/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

import java.util.Scanner;

/**
 *
 * @author FERNANDO
 */
public class Main {
    public static void main(String[] args) {
        SistemaPedidos sistema = new SistemaPedidos();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Restaurante Roky's ---");
            System.out.println("1. Tomar pedido");
            System.out.println("2. Ver pedidos");
            System.out.println("3. Actualizar estado de pedido");
            System.out.println("4. Salir");
            System.out.print("Ingrese opción o escriba 'admin' para administrar el menú: ");
            String opcion = sc.nextLine();

            if (opcion.equalsIgnoreCase("admin")) {
                while (true) {
                    System.out.println("\n-- Modo Administrador --");
                    System.out.println("1. Agregar producto");
                    System.out.println("2. Eliminar producto");
                    System.out.println("3. Modificar producto");
                    System.out.println("4. Mostrar menú");
                    System.out.println("5. Salir de administrador");
                    System.out.print("Ingrese opción: ");
                    String opAdmin = sc.nextLine();

                    switch (opAdmin) {
                        case "1":
                            sistema.agregarProducto(sc);
                            break;
                        case "2":
                            sistema.eliminarProducto(sc);
                            break;
                        case "3":
                            sistema.modificarProducto(sc);
                            break;
                        case "4":
                            sistema.mostrarMenu();
                            break;
                        case "5":
                            System.out.println("Saliendo de modo administrador...");
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                    if (opAdmin.equals("5")) break;
                }
            } else {
                switch (opcion) {
                    case "1":
                        sistema.tomarPedido(sc);
                        break;
                    case "2":
                        sistema.verPedidos();
                        break;
                    case "3":
                        sistema.actualizarEstado(sc);
                        break;
                    case "4":
                        System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Opción inválida, intente nuevamente.");
                }
            }
        }
    }
}