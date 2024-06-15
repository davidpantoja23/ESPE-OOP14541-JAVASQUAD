
package ec.edu.espe.billingsystem.controller;

import ec.edu.espe.billingsystem.model.Inventory;
import ec.edu.espe.billingsystem.model.Product;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */


public class InventoryManager {
    private final Inventory inventory;

    public InventoryManager(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addProduct(Product product) {
        inventory.addProduct(product);
    }

    public void removeProduct(int productId) {
        inventory.removeProduct(productId);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
