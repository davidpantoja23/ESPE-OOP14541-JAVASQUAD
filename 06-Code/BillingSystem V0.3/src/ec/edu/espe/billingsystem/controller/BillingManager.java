
package ec.edu.espe.billingsystem.controller;


/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */


import ec.edu.espe.billingsystem.model.Customer;
import ec.edu.espe.billingsystem.model.Invoice;
import ec.edu.espe.billingsystem.model.InvoiceLine;
import ec.edu.espe.billingsystem.model.PaymentMethod;
import ec.edu.espe.billingsystem.model.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class BillingManager {
    public Invoice createInvoice(Customer customer, List<Product> products, PaymentMethod paymentMethod) {
        Objects.requireNonNull(customer, "Customer cannot be null");
        Objects.requireNonNull(products, "Products cannot be null");
        Objects.requireNonNull(paymentMethod, "Payment method cannot be null");
        Invoice invoice = new Invoice(customer, paymentMethod);
        for (Product product : products) {
            if (product != null && product.getStock() > 0) {
                invoice.addLine(new InvoiceLine(product, product.getStock()));
            }
        }
        return invoice;
    }

    public void saveInvoiceToFile(Invoice invoice, String fileName) {
        Objects.requireNonNull(invoice, "Invoice cannot be null");
        Objects.requireNonNull(fileName, "File name cannot be null");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(invoice.toString());
        } catch (IOException e) {
            System.err.println("An error occurred while saving the invoice to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
