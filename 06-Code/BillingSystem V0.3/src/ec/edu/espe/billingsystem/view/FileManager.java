package ec.edu.espe.billingsystem.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.billingsystem.controller.BillingManager;
import ec.edu.espe.billingsystem.model.Customer;
import ec.edu.espe.billingsystem.model.Invoice;
import ec.edu.espe.billingsystem.model.InvoiceLine;
import ec.edu.espe.billingsystem.model.PaymentMethod;
import ec.edu.espe.billingsystem.model.Product;
import ec.edu.espe.billingsystem.model.TypeOfId;
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
        
        TypeOfId typeOfId = selectTypeOfId();
        
        
    String customerId = InputUtils.getString("Enter customer ID:");      
    String customerName = InputUtils.getString("Enter customer name:");
    String customerEmail = InputUtils.getString("Enter customer email:");
   
    // Create Customer object
    Customer customer = new Customer(customerId, typeOfId, customerName, customerEmail);
    
    PaymentMethod paymentMethod = selectPaymentMethod();

        List<Product> selectedProducts = selectProducts(products);
        Customer Customer;

        Invoice invoice = billingManager.createInvoice(customer, selectedProducts, paymentMethod);
        
        displayInvoiceDetails(invoice);

        saveInvoiceToFile(invoice);
    }
    private static TypeOfId selectTypeOfId() {
        int typeOfId;
        String typeName;

        while (true) {
            System.out.println("Seleccione tipo de documento: (1: Cédula, 2: RUC):");
            typeOfId = InputUtils.getInt("Ingrese tipo de documento: ");

            switch (typeOfId) {
                case 1:
                    typeName = "Cédula";
                    break;
                case 2:
                    typeName = "RUC";
                    break;
                default:
                    System.out.println("Dato incorrecto, ingrese nuevamente");
                    continue; // Volver a solicitar la entrada
            }
            break; // Salir del bucle si se ingresa una opción válida
        }

        return new TypeOfId(typeOfId, typeName);
    }


    private static List<Product> initializeProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Hamburguesa 1/2", 5.99, 100));
        products.add(new Product(2, "Porción de papas", 2.99, 200));
        products.add(new Product(3, "Gaseosa litro", 2.00, 300));
        products.add(new Product(3, "Gaseosa", 0.85, 300));
        products.add(new Product(4, "Hamburguesa 1/4", 4.99, 150));
        products.add(new Product(5, "Porción de ensalada", 2.00, 80));
        products.add(new Product(6, "Chicken fingers", 4.99, 120));
        products.add(new Product(7, "Soda italiana", 2.49, 90));
        products.add(new Product(8, "Filete de pollo", 4.99, 200));
        products.add(new Product(9, "Costillita 300", 4.99, 250));
        products.add(new Product(10, "Costilla 500", 8.49, 70));
        products.add(new Product(11, "Milkshake", 3.75, 100));
        products.add(new Product(12, "Vaso limonada", 2.45, 100));
        products.add(new Product(13, "Jarra limonada", 5.00, 200));
        products.add(new Product(14, "Mochi", 1.00, 50));
        products.add(new Product(15, "Promoción costilla", 19.99, 100));
        products.add(new Product(16, "Promo día", 5.99, 50));
        products.add(new Product(17, "Bife", 8.99, 50));
        products.add(new Product(18, "Chuleta", 4.99, 60));
        products.add(new Product(19, "8 alitas", 5.99, 100));
        products.add(new Product(20, "12 alitas", 8.99, 70));
        products.add(new Product(21, "24 alitas", 17.89, 40));
        products.add(new Product(22, "Nachos", 3.99, 100));
        products.add(new Product(23, "Mojito", 3.75, 50));
        
        return products;
    }

private static PaymentMethod selectPaymentMethod() {
    int paymentMethodId;
    String paymentMethodName;

    while (true) {
        System.out.println("Select payment method (1: Cash, 2: Credit Card, 3: Mobile Payment):");
        paymentMethodId = InputUtils.getInt("Enter payment method ID:");

        switch (paymentMethodId) {
            case 1:
                paymentMethodName = "Cash";
                break;
            case 2:
                paymentMethodName = "Credit Card";
                break;
            case 3:
                paymentMethodName = "Mobile Payment";
                break;
            default:
                System.out.println("Invalid payment method. Please try again.");
                continue; // Volver a solicitar la entrada
        }
        break; // Salir del bucle si se ingresa una opción válida
    }

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
        System.out.println("Type Of ID: " + invoice.getCustomer().getTypeOfId().getTypeName());
        System.out.println("ID: "  + invoice.getCustomer().getTypeOfId().getId() );
        System.out.println("Customer: " + invoice.getCustomer().getName());
        System.out.println("Payment Method: " + invoice.getPaymentMethod().getName());
        System.out.println("Products:");
        
       for (InvoiceLine line : invoice.getLines()) {
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
