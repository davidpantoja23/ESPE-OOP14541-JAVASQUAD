
package ec.edu.espe.billingsystem.model;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */


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
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.lines = new ArrayList<>();
    }

    public void addLine(InvoiceLine line) {
        lines.add(line);
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
        return lines;
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