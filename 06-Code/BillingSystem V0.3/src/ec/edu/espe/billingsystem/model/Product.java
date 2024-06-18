
package ec.edu.espe.billingsystem.model;
import java.util.Objects;
/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */

public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID del producto no puede ser negativo");
        }
        this.id = id;

        this.name = Objects.requireNonNull(name, "El nombre del producto no puede ser nulo");

        if (price <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo.");
        }
        this.price = price;

        if (stock < 0) {
            throw new IllegalArgumentException("La acción no puede ser negativa.");
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
            throw new IllegalArgumentException("La acción no puede ser negativa.");
        }
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + ", stock=" + stock + '}';
    }
}
