/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.aristeobillingsystem.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class Inventory {
    
    private ArrayList<Product> products;

    public Inventory(ArrayList<Product> products) {
        this.products = new ArrayList<>(Objects.requireNonNull(products, "La lista de productos no puede ser nula"));
    }

    public void addProduct(Product product) {
        Objects.requireNonNull(product, "El producto no puede ser nulo");
        products.add(product);
    }

    public void removeProduct(int productId) {
        products.removeIf(p -> p.getId() == productId);
    }

    /**
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    /**
     * @param products the products to set
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = new ArrayList<>(Objects.requireNonNull(products, "La lista de productos no puede ser nula"));
    }
}
