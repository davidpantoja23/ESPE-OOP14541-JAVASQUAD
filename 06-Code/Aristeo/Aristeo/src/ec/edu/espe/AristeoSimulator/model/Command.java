/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.AristeoSimulator.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class Command {
    private int tableNumber;
    private List<Product> products;
    private String status; // e.g., "pending", "preparing", "completed"
    private double vatPercentage;

    public Command(int tableNumber, double vatPercentage) {
        this.tableNumber = tableNumber;
        this.products = new ArrayList<>();
        this.status = "pending";
        this.vatPercentage = vatPercentage;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeItem(Product product) {
        products.remove(product);
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (Product item : products) {
            subtotal += item.getUnitPrice() * item.getQuantity();
        }
        return subtotal;
    }

    public double calculateVAT() {
        return calculateSubtotal() * (vatPercentage / 100);
    }

    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        double vat = calculateVAT();
        return subtotal + vat;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public List<Product> getItems() {
        return products;
    }

    public String getStatus() {
        return status;
    }
}
