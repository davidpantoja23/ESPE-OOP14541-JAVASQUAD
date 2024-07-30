/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.aristeobillingsystem.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.aristeobillingsystem.model.Invoice;
import ec.edu.espe.aristeobillingsystem.model.InvoiceLine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class ControllerReport {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public ArrayList<Invoice> loadInvoicesFromFiles(ArrayList<String> fileNames) {
        ArrayList<Invoice> invoices = new ArrayList<>();
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

    public ArrayList<Invoice> filterInvoicesById(ArrayList<Invoice> invoices, String idNumber) {
        return invoices.stream()
                .filter(invoice -> invoice.getCustomer().getDni().equals(idNumber))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
