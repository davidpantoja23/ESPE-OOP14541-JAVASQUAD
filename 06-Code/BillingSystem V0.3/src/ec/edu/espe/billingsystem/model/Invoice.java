
package ec.edu.espe.billingsystem.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents an invoice.
 * Author: David Pantoja, JavaSquad, DCCO-ESPE
 */
public class Invoice {
    private final Customer customer;
    private final List<InvoiceLine> lines;
    private final PaymentMethod paymentMethod;
    private final TypeOfId typeOfId;  // Ensure typeOfId is correctly set and used
    private double subtotal;
    private double vat;
    private double total;

    public Invoice(Customer customer, PaymentMethod paymentMethod) {
        this.customer = Objects.requireNonNull(customer, "El cliente no puede ser nulo");
        this.paymentMethod = Objects.requireNonNull(paymentMethod, "El método de pago no puede ser nulo");
        this.typeOfId = customer.getTypeOfId();  // Initialize typeOfId from the customer
        this.lines = new ArrayList<>();
    }

    public void addLine(InvoiceLine line) {
        lines.add(Objects.requireNonNull(line, "La línea de factura no puede ser nula"));
        updateTotals();
    }

    private void updateTotals() {
        subtotal = lines.stream().mapToDouble(InvoiceLine::getSubtotal).sum();
        vat = subtotal * 0.15;
        total = subtotal + vat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public List<InvoiceLine> getLines() {
        return new ArrayList<>(lines);
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getVat() {
        return vat;
    }

    public double getTotal() {
        return total;
    }

    public TypeOfId getTypeOfId() {
        return typeOfId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customer=" + customer +
                ", lines=" + lines +
                ", paymentMethod=" + paymentMethod +
                ", subtotal=" + subtotal +
                ", vat=" + vat +
                ", total=" + total +
                '}';
    }
}
