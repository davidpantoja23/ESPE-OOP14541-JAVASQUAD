/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.aristeobillingsystem.model;

import java.awt.List;
import static java.nio.file.Files.lines;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class Invoice {
    
    private Customer customer;
    private ArrayList<InvoiceLine> lines;
    private PaymentMethod paymentMethod;
    private double subTotal;
    private double vat;
    private double total;

    public Invoice(Customer customer, ArrayList<InvoiceLine> lines, PaymentMethod paymentMethod) {
        validateInvoiceDetails(customer, paymentMethod);
        this.customer = customer;
        this.lines = new ArrayList<>(lines);
        this.paymentMethod = paymentMethod;
        updateTotals();
    }

    private void validateInvoiceDetails(Customer customer, PaymentMethod paymentMethod) {
        Objects.requireNonNull(customer, "El cliente no puede ser nulo");
        Objects.requireNonNull(paymentMethod, "El método de pago no puede ser nulo");
    }

    public void addLine(InvoiceLine line) {
        lines.add(Objects.requireNonNull(line, "La línea de factura no puede ser nula"));
        updateTotals();
    }

    private void updateTotals() {
        subTotal = lines.stream().mapToDouble(InvoiceLine::getSubTotal).sum();
        vat = subTotal * 0.15;
        total = subTotal + vat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<InvoiceLine> getLines() {
        return new ArrayList<>(lines);
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = new ArrayList<>(lines);
        updateTotals();
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getVat() {
        return vat;
    }

    public double getTotal() {
        return total;
    }
}
