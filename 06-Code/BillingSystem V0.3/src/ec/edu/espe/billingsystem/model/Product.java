
package ec.edu.espe.billingsystem.model;

import java.util.Objects;

/**
 * Represents a product.
 * Author: David Pantoja, JavaSquad, DCCO-ESPE
 */
public class Product {
    private final int id;
    private final String name;
    private final double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID del producto no puede ser negativo.");
        }
        this.id = id;

        this.name = Objects.requireNonNull(name, "El nombre del producto no puede ser nulo.");

        if (price <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo.");
        }
        this.price = price;

        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
