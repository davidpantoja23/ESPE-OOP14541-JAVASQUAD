
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
<<<<<<< HEAD
            throw new IllegalArgumentException("Debe ingresar un número positivo");
        }
        this.id = id;

        this.name = Objects.requireNonNull(name, "Campo requerido");

        if (price <= 0) {
            throw new IllegalArgumentException("Debe ingresar un número positivo");
=======
            throw new IllegalArgumentException("El ID del producto no puede ser negativo");
        }
        this.id = id;

        this.name = Objects.requireNonNull(name, "El nombre del producto no puede ser nulo");

        if (price <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo.");
>>>>>>> 947e8e8b567d8ea6453ad7e427a783eeb8ea36df
        }
        this.price = price;

        if (stock < 0) {
<<<<<<< HEAD
            throw new IllegalArgumentException("Debe ingresar un número positivo");
=======
            throw new IllegalArgumentException("La acción no puede ser negativa.");
>>>>>>> 947e8e8b567d8ea6453ad7e427a783eeb8ea36df
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
<<<<<<< HEAD
            throw new IllegalArgumentException("Debe ingresar un número positivo");
=======
            throw new IllegalArgumentException("La acción no puede ser negativa.");
>>>>>>> 947e8e8b567d8ea6453ad7e427a783eeb8ea36df
        }
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + ", stock=" + stock + '}';
    }
}
