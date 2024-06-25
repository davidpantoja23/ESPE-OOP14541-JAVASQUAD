/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.billingsystem.model;

/**
 *
 * @author Simone Medina, JavaSquad, DCCO-ESPE
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.billingsystem.model.Invoice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportViewer {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public List<Invoice> loadInvoicesFromFiles(List<String> fileNames) {
        List<Invoice> invoices = new ArrayList<>();
        for (String fileName : fileNames) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                Invoice invoice = GSON.fromJson(reader, Invoice.class);
                invoices.add(invoice);
            } catch (IOException e) {
                System.err.println("Error al leer el archivo " + fileName + ": " + e.getMessage());
            }
        }
        return invoices;
    }

    public List<Invoice> filterInvoicesById(List<Invoice> invoices, String idNumber) {
        return invoices.stream()
                .filter(invoice -> invoice.getCustomer().getTypeOfId().getIdNumber().equals(idNumber))
                .collect(Collectors.toList());
    }

    public void displayInvoices(List<Invoice> invoices) {
        for (Invoice invoice : invoices) {
            displayInvoiceDetails(invoice);
            System.out.println("------------------------------------------");
        }
    }

    private void displayInvoiceDetails(Invoice invoice) {
        System.out.println("------------------------------------------");
        System.out.println("| Factura                                  |");
        System.out.println("------------------------------------------");
        System.out.printf("| Tipo de ID: %-29s |%n", invoice.getCustomer().getTypeOfId().getTypeName() + " (" + invoice.getCustomer().getTypeOfId().getIdNumber() + ")");
        System.out.printf("| Cliente: %-29s |%n", invoice.getCustomer().getName());
        System.out.printf("| Método de pago: %-23s |%n", invoice.getPaymentMethod().getName());
        System.out.println("------------------------------------------");
        System.out.println("| Productos:                               |");
        for (InvoiceLine line : invoice.getLines()) {
            System.out.printf("| %-25s %3d x $%-6.2f |%n", line.getProduct().getName(), line.getQuantity(), line.getProduct().getPrice());
        }
        System.out.println("------------------------------------------");
        System.out.printf("| Subtotal: $%-28.2f |%n", invoice.getSubtotal());
        System.out.printf("| IVA: $%-33.2f |%n", invoice.getVat());
        System.out.printf("| Total: $%-31.2f |%n", invoice.getTotal());
        System.out.println("------------------------------------------");
    }
}
