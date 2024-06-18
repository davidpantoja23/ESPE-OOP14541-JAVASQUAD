
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
            throw new IllegalArgumentException("Debe ingresar un número positivo");
        }
        this.id = id;

        this.name = Objects.requireNonNull(name, "Campo requerido");

        if (price <= 0) {
            throw new IllegalArgumentException("Debe ingresar un número positivo");
        }
        this.price = price;

        if (stock < 0) {
            throw new IllegalArgumentException("Debe ingresar un número positivo");
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
            throw new IllegalArgumentException("Debe ingresar un número positivo");
        }
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + ", stock=" + stock + '}';
    }
}
