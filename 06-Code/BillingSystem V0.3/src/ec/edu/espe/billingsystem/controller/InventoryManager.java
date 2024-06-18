
package ec.edu.espe.billingsystem.controller;

import ec.edu.espe.billingsystem.model.Inventory;
import ec.edu.espe.billingsystem.model.Product;

import java.util.Objects;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */

public class InventoryManager {
    private final Inventory inventory;
    public InventoryManager(Inventory inventory) {
        this.inventory = Objects.requireNonNull(inventory, "El inventario no puede ser nulo.");
    }
    public void addProduct(Product product) {
        Objects.requireNonNull(product, "El producto no puede ser nulo.");
        inventory.addProduct(product);
    }
    public void removeProduct(int productId) {
        inventory.removeProduct(productId);
    }
    public Inventory getInventory() {
        return inventory;
    }
}
