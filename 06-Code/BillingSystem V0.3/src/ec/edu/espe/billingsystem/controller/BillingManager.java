
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
        Objects.requireNonNull(customer, "Debe ingresar información en este campo");
        Objects.requireNonNull(products, "Debe seleccionar un producto");
        Objects.requireNonNull(paymentMethod, "Debe seleccionar un método de pago");
        Invoice invoice = new Invoice(customer, paymentMethod);
        for (Product product : products) {
            if (product != null && product.getStock() > 0) {
                invoice.addLine(new InvoiceLine(product, product.getStock()));
            }
        }
        return invoice;
    }

    public void saveInvoiceToFile(Invoice invoice, String fileName) {
        Objects.requireNonNull(invoice, "Ingrese datos para facturación");
        Objects.requireNonNull(fileName, "Debe ingresar el nombre del documento");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(invoice.toString());
        } catch (IOException e) {
            System.err.println("Un error ha ocurrido cuando se guardaba la factura: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
