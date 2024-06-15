
package ec.edu.espe.billingsystem.view;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import java.io.FileWriter;
import com.google.gson.JsonObject;
import ec.edu.espe.billingsystem.controller.BillingManager;
import ec.edu.espe.billingsystem.model.Customer;
import ec.edu.espe.billingsystem.model.Invoice;
import ec.edu.espe.billingsystem.model.PaymentMethod;
import ec.edu.espe.billingsystem.model.Product;
import ec.edu.espe.billingsystem.utils.InputUtils;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class FileManager {
private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
private static final BillingManager billingManager = new BillingManager();
    public static void addBilling() {


        // Initialize products
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Burger", 5.99, 100));
        products.add(new Product(2, "Fries", 2.99, 200));
        products.add(new Product(3, "Soda", 1.49, 300));

        // Enter customer details
        int customerId = InputUtils.getInt("Enter customer ID:");
        String customerName = InputUtils.getString("Enter customer name:");
        String customerEmail = InputUtils.getString("Enter customer email:");

        Customer customer = new Customer(customerId, customerName, customerEmail);

        // Select payment method
        System.out.println("Select payment method (1: Cash, 2: Credit Card, 3: Mobile Payment):");
        int paymentMethodId = InputUtils.getInt("Enter payment method ID:");
        String paymentMethodName = switch (paymentMethodId) {
            case 1 -> "Cash";
            case 2 -> "Credit Card";
            case 3 -> "Mobile Payment";
            default -> throw new IllegalArgumentException("Invalid payment method");
        };

        PaymentMethod paymentMethod = new PaymentMethod(paymentMethodId, paymentMethodName);

        // Select products
        List<Product> selectedProducts = new ArrayList<>();
        boolean addingProducts = true;
        while (addingProducts) {
            System.out.println("Available products:");
            for (Product product : products) {
                System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
            }

            int productId = InputUtils.getInt("Enter product ID to add to invoice (0 to finish):");
            if (productId == 0) {
                addingProducts = false;
                break;
            }

            Product selectedProduct = null;
            for (Product product : products) {
                if (product.getId() == productId) {
                    selectedProduct = product;
                    break;
                }
            }

            if (selectedProduct != null) {
                int quantity = InputUtils.getInt("Enter quantity:");
                selectedProducts.add(new Product(selectedProduct.getId(), selectedProduct.getName(), selectedProduct.getPrice(), quantity));
            } else {
                System.out.println("Invalid product ID");
            }
        }

        // Create invoice
        Invoice invoice = billingManager.createInvoice(customer, selectedProducts, paymentMethod);

        // Display invoice
        System.out.println("Invoice created:");
        System.out.println("Customer: " + invoice.getCustomer().getName());
        System.out.println("Payment Method: " + invoice.getPaymentMethod().getName());
        System.out.println("Products:");
        for (var line : invoice.getLines()) {
            System.out.println(line.getProduct().getName() + ": " + line.getQuantity() + " x $" + line.getProduct().getPrice());
        }
        System.out.println("Subtotal: $" + invoice.getSubtotal());
        System.out.println("VAT: $" + invoice.getVat());
        System.out.println("Total: $" + invoice.getTotal());

        // Save invoice to file
        String fileName = InputUtils.getString("Enter file name to save invoice:");
        JsonArray invoiceJson = new JsonArray();
        invoiceJson.add(GSON.toJsonTree(invoice));
        
        
        JsonObject payrollsJson = new JsonObject();
        payrollsJson.add("Individualinvoices", invoiceJson);

        try (FileWriter writer = new FileWriter(fileName)) {
                GSON.toJson(payrollsJson, writer);
                System.out.println("Payrolls generated and saved in payrolls.json");
            } catch (IOException e) {
                System.out.println("Error saving payrolls: " + e.getMessage());
            }

        System.out.println("Invoice saved to " + fileName);
    }
}