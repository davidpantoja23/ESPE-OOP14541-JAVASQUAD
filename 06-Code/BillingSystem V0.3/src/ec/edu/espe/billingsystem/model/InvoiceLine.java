
package ec.edu.espe.billingsystem.model;

import java.util.Objects;

/**
 * Represents a line item in an invoice.
 * @author: JavaSquad, DCCO-ESPE
 */
public class InvoiceLine {
    private final Product product;
    private final int quantity;

    public InvoiceLine(Product product, int quantity) {
        this.product = Objects.requireNonNull(product, "Debe seleccionar al menos un producto");
        if (quantity < 0) {
            throw new IllegalArgumentException("Debe seleccionar un número positivo");
        }
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
