package ec.edu.espe.AristeoSimulator.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class Inventory {
    private Map<Integer, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getIdProduct(), product);
    }

    public void removeProduct(int idProduct) {
        products.remove(idProduct);
    }

    public void updateStock(int idProduct, int quantity) {
        Product product = products.get(idProduct);
        if (product != null) {
            product.setQuantity(product.getQuantity() + quantity);
        }
    }

    public Product getProduct(int idProduct) {
        return products.get(idProduct);
    }

    public void displayInventory() {
        for (Product product : products.values()) {
            System.out.println("ID: " + product.getIdProduct() + ", Name: " + product.getName() + ", Quantity: " + product.getQuantity() + ", Unit Price: " + product.getUnitPrice());
        }
    }
}
