
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

public class BillingManager {
    public Invoice createInvoice(Customer customer, List<Product> products, PaymentMethod paymentMethod) {
        Invoice invoice = new Invoice(customer, paymentMethod);
        for (Product product : products) {
            invoice.addLine(new InvoiceLine(product, product.getStock()));
        }
        return invoice;
    }

    public void saveInvoiceToFile(Invoice invoice, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(invoice.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}