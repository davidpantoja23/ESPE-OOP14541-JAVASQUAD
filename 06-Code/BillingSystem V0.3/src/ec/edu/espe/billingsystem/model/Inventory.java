
package ec.edu.espe.billingsystem.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */
import java.util.ArrayList;
import java.util.List;



public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }
    
    public Inventory(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Inventory{" + "products=" + products + '}';
    }

    //public Inventory(List<Product> products) {
     //   this.products = products;
    //}
    
    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        products.removeIf(p -> p.getId() == productId);
    }

    public List<Product> getProducts() {
        return products;
    }
    
}


