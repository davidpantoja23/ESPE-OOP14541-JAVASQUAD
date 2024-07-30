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
    private TypeOfId typeOfId;
    private double subTotal;
    private double vat;
    private double total;

    public Invoice(Customer customer, ArrayList<InvoiceLine> lines, PaymentMethod paymentMethod, TypeOfId typeOfId, double subTotal, double vat, double total) {
        validateInvoiceDetails(customer, paymentMethod);
        this.customer = customer;
        this.lines = lines;
        this.paymentMethod = paymentMethod;
        this.typeOfId = typeOfId;
        this.subTotal = subTotal;
        this.vat = vat;
        this.total = total;
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

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the line
     */
    public ArrayList<InvoiceLine> getLine() {
        return new ArrayList<>(lines);
    }

    /**
     * @param line the line to set
     */
    public void setLine(ArrayList<InvoiceLine> line) {
        this.lines = line;
    }

    /**
     * @return the paymentMethod
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * @return the typeOfId
     */
    public TypeOfId getTypeOfId() {
        return typeOfId;
    }

    /**
     * @param typeOfId the typeOfId to set
     */
    public void setTypeOfId(TypeOfId typeOfId) {
        this.typeOfId = typeOfId;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the vat
     */
    public double getVat() {
        return vat;
    }

    /**
     * @param vat the vat to set
     */
    public void setVat(double vat) {
        this.vat = vat;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
}
