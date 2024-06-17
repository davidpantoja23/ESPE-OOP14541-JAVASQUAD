
package ec.edu.espe.billingsystem.model;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private final Customer customer;
    private final List<InvoiceLine> lines;
    private final PaymentMethod paymentMethod;
    private double subtotal;
    private double vat;
    private double total;

    public Invoice(Customer customer, PaymentMethod paymentMethod) {
        this.customer = Objects.requireNonNull(customer, "Customer cannot be null");
        this.paymentMethod = Objects.requireNonNull(paymentMethod, "Payment method cannot be null");
        this.lines = new ArrayList<>();
    }

    public void addLine(InvoiceLine line) {
        lines.add(Objects.requireNonNull(line, "Invoice line cannot be null"));
        updateTotals();
    }

    private void updateTotals() {
        subtotal = lines.stream().mapToDouble(InvoiceLine::getSubtotal).sum();
        vat = subtotal * 0.12;
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

    @Override
    public String toString() {
        return "Invoice{" + "customer=" + customer + ", lines=" + lines + ", paymentMethod=" + paymentMethod + ", subtotal=" + subtotal + ", vat=" + vat + ", total=" + total + '}';
    }
}
