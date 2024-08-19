/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.aristeobillingsystem.controller;

import ec.edu.espe.aristeobillingsystem.model.Inventory;
import ec.edu.espe.aristeobillingsystem.model.Product;
import java.util.Objects;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class ControllerProduct {

    private static Inventory inventory;

    public static void addProduct(Product product) {
        Objects.requireNonNull(product, "El producto no puede ser nulo.");
        inventory.addProduct(product);
    }

    public void removeProduct(int productId) {
        if (productId < 0) {
            throw new IllegalArgumentException("El ID del producto no puede ser negativo.");
        }
        inventory.removeProduct(productId);
    }
}
