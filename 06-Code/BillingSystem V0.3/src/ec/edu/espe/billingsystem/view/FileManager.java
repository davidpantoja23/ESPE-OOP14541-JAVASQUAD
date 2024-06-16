package ec.edu.espe.billingsystem.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.billingsystem.controller.BillingManager;
import ec.edu.espe.billingsystem.model.Customer;
import ec.edu.espe.billingsystem.model.Invoice;
import ec.edu.espe.billingsystem.model.PaymentMethod;
import ec.edu.espe.billingsystem.model.Product;
import ec.edu.espe.billingsystem.utils.InputUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */

public class FileManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final BillingManager billingManager = new BillingManager();

    public static void addBilling() {
        List<Product> products = initializeProducts();

        // Enter customer details
        int customerId = InputUtils.getInt("Enter customer ID:");
        String customerName = InputUtils.getString("Enter customer name:");
        String customerEmail = InputUtils.getString("Enter customer email:");
        Customer customer = new Customer(customerId, customerName, customerEmail);

        PaymentMethod paymentMethod = selectPaymentMethod();

        List<Product> selectedProducts = selectProducts(products);

        Invoice invoice = billingManager.createInvoice(customer, selectedProducts, paymentMethod);
        
        displayInvoiceDetails(invoice);

        saveInvoiceToFile(invoice);
    }

    private static List<Product> initializeProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Burger", 5.99, 100));
        products.add(new Product(2, "Fries", 2.99, 200));
        products.add(new Product(3, "Soda", 1.49, 300));
        products.add(new Product(4, "Burger", 4.99, 150));
        products.add(new Product(5, "Salad", 3.99, 80));
        products.add(new Product(6, "Chicken Sandwich", 5.49, 120));
        products.add(new Product(7, "Ice Cream", 2.49, 90));
        products.add(new Product(8, "Coffee", 1.99, 200));
        products.add(new Product(9, "Tea", 1.49, 250));
        products.add(new Product(10, "Milkshake", 3.49, 70));
        return products;
    }

    private static PaymentMethod selectPaymentMethod() {
        System.out.println("Select payment method (1: Cash, 2: Credit Card, 3: Mobile Payment):");
        int paymentMethodId = InputUtils.getInt("Enter payment method ID:");
        String paymentMethodName = switch (paymentMethodId) {
            case 1 -> "Cash";
            case 2 -> "Credit Card";
            case 3 -> "Mobile Payment";
            default -> throw new IllegalArgumentException("Invalid payment method");
        };
        return new PaymentMethod(paymentMethodId, paymentMethodName);
    }

    private static List<Product> selectProducts(List<Product> products) {
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

            Product selectedProduct = products.stream()
                    .filter(p -> p.getId() == productId)
                    .findFirst()
                    .orElse(null);

            if (selectedProduct != null) {
                int quantity = InputUtils.getInt("Enter quantity:");
                selectedProducts.add(new Product(selectedProduct.getId(), selectedProduct.getName(), selectedProduct.getPrice(), quantity));
            } else {
                System.out.println("Invalid product ID");
            }
        }
        return selectedProducts;
    }

    private static void displayInvoiceDetails(Invoice invoice) {
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
    }

    private static void saveInvoiceToFile(Invoice invoice) {
        String fileName = InputUtils.getString("Enter file name to save invoice:");
        try (FileWriter writer = new FileWriter(fileName)) {
            GSON.toJson(invoice, writer);
            System.out.println("Invoice saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving invoice: " + e.getMessage());
        }
    }
}
