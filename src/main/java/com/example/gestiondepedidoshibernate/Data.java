package com.example.gestiondepedidoshibernate;

import com.example.gestiondepedidoshibernate.domain.products.Product;
import com.example.gestiondepedidoshibernate.domain.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidad para la generación de datos de ejemplo.
 *
 * @since 1.0
 */
public class Data {
    /**
     * Genera una lista de usuarios de ejemplo.
     *
     * @return Una lista de usuarios de ejemplo.
     */
    public static List<User> generarUsuarios() {
        List<User> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new User("Fernando", "1234", "fernandoperez@gmail.com", new ArrayList<>()));
        listaUsuarios.add(new User("Pablo", "1234", "pablorobles@gmail.com", new ArrayList<>()));
        return listaUsuarios;
    }

    /**
     * Genera una lista de productos de ejemplo.
     *
     * @return Una lista de productos de ejemplo.
     */
    public static List<Product> generarProductos() {
        List<Product> listaProductos = new ArrayList<>();
        listaProductos.add(new Product("Sillón", 100.0, 60));
        listaProductos.add(new Product("Mesa", 200.0, 100));
        listaProductos.add(new Product("Silla", 79.0, 200));
        listaProductos.add(new Product("Sofá", 400.0, 70));
        listaProductos.add(new Product("Televisión", 800.0, 80));
        return listaProductos;
    }
}
