/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.aristeobillingsystem.model;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class InvoiceLine {
    private String description;
    private int quantity;
    private double unitPrice;
    private double subTotal;

    public InvoiceLine(String description, int quantity, double unitPrice) {
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subTotal = calculateSubTotal();
    }

    private double calculateSubTotal() {
        return quantity * unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.subTotal = calculateSubTotal();
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        this.subTotal = calculateSubTotal();
    }

    public double getSubTotal() {
        return subTotal;
    }
}