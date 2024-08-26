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
        validateInvoiceLineDetails(description, quantity, unitPrice);
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subTotal = calculateSubTotal();
    }

    private void validateInvoiceLineDetails(String description, int quantity, double unitPrice) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede ser nula o vacía.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("El precio por unidad debe ser positivo.");
        }
    }

    private double calculateSubTotal() {
        return quantity * unitPrice;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede ser nula o vacía.");
        }
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.quantity = quantity;
        this.subTotal = calculateSubTotal();
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("El precio por unidad debe ser positivo.");
        }
        this.unitPrice = unitPrice;
        this.subTotal = calculateSubTotal();
    }

    public double getSubTotal() {
        return subTotal;
    }
}