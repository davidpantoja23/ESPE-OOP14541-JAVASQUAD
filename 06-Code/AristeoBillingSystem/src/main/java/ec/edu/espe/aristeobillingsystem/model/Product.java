/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.aristeobillingsystem.model;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class Product {

    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        validateProductDetails(id, name, price, stock);
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    private void validateProductDetails(int id, String name, double price, int stock) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID del producto no puede ser negativo.");
        }

        if (name == null) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo.");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo.");
        }

        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID del producto no puede ser negativo.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo.");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo.");
        }
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.stock = stock;
    }

}
