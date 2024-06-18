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

public class FileManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final BillingManager billingManager = new BillingManager();

    public static void addBilling() {
        List<Product> products = initializeProducts();

        // Enter customer details
        TypeOfId typeOfId = selectTypeOfId();

        String customerId = typeOfId.getIdNumber(); // Use the idNumber from TypeOfId
        String customerName = InputUtils.getString("Nombre cliente:");
        String customerEmail = InputUtils.getString("Correo electrónico:");

        // Create Customer object
        Customer customer = new Customer(customerId, typeOfId, customerName, customerEmail);
        PaymentMethod paymentMethod = selectPaymentMethod();
        List<Product> selectedProducts = selectProducts(products);
        Invoice invoice = billingManager.createInvoice(customer, selectedProducts, paymentMethod);
        displayInvoiceDetails(invoice);
        saveInvoiceToFile(invoice);
    }

    private static TypeOfId selectTypeOfId() {
        int typeOfId;
        String typeName = "";
        String idNumber = "";

        while (true) {
            System.out.println("Seleccione el tipo de documento: (1: Cédula, 2: RUC):");
            typeOfId = InputUtils.getInt("Ingrese el tipo de documento: ");

            switch (typeOfId) {
                case 1:
                    typeName = "Cédula";
                    break;
                case 2:
                    typeName = "RUC";
                    break;
                default:
                    System.out.println("Información incorrecta, ingrese nuevamente");
                    continue;
            }

            while (true) {
                idNumber = InputUtils.getString("Ingrese " + typeName + " (únicamente números):");

                // Validate length and digit content
                if (!idNumber.matches("\\d+")) {
                    System.out.println("El documento de identidad " + typeName + " debe contener únicamente números. Intente nuevamente.");
                } else if ((typeOfId == 1 && idNumber.length() != 10) || (typeOfId == 2 && idNumber.length() != 13)) {
                    System.out.println("Recuerde el RUC tiene 13 dígitos");
                } else {
                    // Validate first two digits
                    int provinceCode = Integer.parseInt(idNumber.substring(0, 2));
                    if (provinceCode < 1 || provinceCode > 24) {
                        System.out.println("Los primeros dos dígitos del " + typeName + " deben estar entre 01 y 24. Intente nuevamente.");
                    } else {
                        break;
                    }
                }
            }

            break;
        }

        return new TypeOfId(typeOfId, typeName, idNumber);
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
        products.add(new Product(23, "Mojito", 3.75, 30));

        return products;
    }

    private static PaymentMethod selectPaymentMethod() {
        int paymentMethodId;
        String paymentMethodName;

        while (true) {
<<<<<<< HEAD
            System.out.println("Seleccione el método de pago: (1: Efectivo, 2: Tarjeta de crédito, 3: Pago móvil):");
            paymentMethodId = InputUtils.getInt("Ingrese el método de pago:");
=======
            System.out.println("Seleccione método de pago: (1: Efectivo, 2: Tarjeta de crédito, 3: Pago móvil):");
            paymentMethodId = InputUtils.getInt("Ingrese el ID del método de pago:");
>>>>>>> 947e8e8b567d8ea6453ad7e427a783eeb8ea36df

            switch (paymentMethodId) {
                case 1:
                    paymentMethodName = "Efectivo";
                    break;
                case 2:
<<<<<<< HEAD
                    paymentMethodName = "Tarjeta de crédito";
                    break;
                case 3:
                    paymentMethodName = "Pago móvil";
                    break;
                default:
                    System.out.println("Método de pago inválido. Por favor intente nuevamente.");
=======
                    paymentMethodName = "Tarjeta de credito";
                    break;
                case 3:
                    paymentMethodName = "Pago movil";
                    break;
                default:
                    System.out.println("Método de pago no válido. Inténtalo de nuevo.");
>>>>>>> 947e8e8b567d8ea6453ad7e427a783eeb8ea36df
                    continue;
            }
            break;
        }

        return new PaymentMethod(paymentMethodId, paymentMethodName);
    }

    private static List<Product> selectProducts(List<Product> products) {
        List<Product> selectedProducts = new ArrayList<>();
        boolean addingProducts = true;
        while (addingProducts) {
            System.out.println("------------------------------------------");
            System.out.println("| Productos disponibles                   |");
            System.out.println("------------------------------------------");
            for (Product product : products) {
                System.out.printf("| %d: %-30s $%.2f |%n", product.getId(), product.getName(), product.getPrice());
            }
            System.out.println("------------------------------------------");

<<<<<<< HEAD
            int productId = InputUtils.getInt("Ingrese el ID del producto a añadir (0 para finalizar):");
=======
            int productId = InputUtils.getInt("Ingrese el ID del producto para agregar a la factura (0 para finalizar):");
>>>>>>> 947e8e8b567d8ea6453ad7e427a783eeb8ea36df
            if (productId == 0) {
                addingProducts = false;
                break;
            }

            Product selectedProduct = products.stream()
                    .filter(p -> p.getId() == productId)
                    .findFirst()
                    .orElse(null);

            if (selectedProduct != null) {
<<<<<<< HEAD
                int quantity = InputUtils.getInt("Ingrese la cantidad:");
                selectedProducts.add(new Product(selectedProduct.getId(), selectedProduct.getName(), selectedProduct.getPrice(), quantity));
            } else {
                System.out.println("ID de producto inválido");
=======
                int quantity = InputUtils.getInt("Introduzca la cantidad:");
                selectedProducts.add(new Product(selectedProduct.getId(), selectedProduct.getName(), selectedProduct.getPrice(), quantity));
            } else {
                System.out.println("ID de producto no válido");
>>>>>>> 947e8e8b567d8ea6453ad7e427a783eeb8ea36df
            }
        }
        return selectedProducts;
    }

    private static void displayInvoiceDetails(Invoice invoice) {
        System.out.println("------------------------------------------");
<<<<<<< HEAD
        System.out.println("| Factura creada                           |");
        System.out.println("------------------------------------------");
        System.out.printf("| Tipo de documento: %-29s |%n", invoice.getCustomer().getTypeOfId().getTypeName() + " (" + invoice.getCustomer().getTypeOfId().getIdNumber() + ")");
        System.out.printf("| Cliente: %-29s |%n", invoice.getCustomer().getName());
        System.out.printf("| Método de pago: %-23s |%n", invoice.getPaymentMethod().getName());
=======
        System.out.println("| Factura creada                         |");
        System.out.println("------------------------------------------");
        System.out.printf("| Tipo de ID: %-29s |%n", invoice.getCustomer().getTypeOfId().getTypeName() + " (" + invoice.getCustomer().getTypeOfId().getId() + ")");
        System.out.printf("| Cliente: %-29s |%n", invoice.getCustomer().getName());
        System.out.printf("| Metodo de pago: %-23s |%n", invoice.getPaymentMethod().getName());
>>>>>>> 947e8e8b567d8ea6453ad7e427a783eeb8ea36df
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

    private static void saveInvoiceToFile(Invoice invoice) {
        String fileName = InputUtils.getString("Ingrese el nombre del archivo para guardar la factura:");
        try (FileWriter writer = new FileWriter(fileName)) {
            GSON.toJson(invoice, writer);
<<<<<<< HEAD
            System.out.println("Factura guardada en " + fileName);
        } catch (IOException e) {
            System.out.println("Error al guardar la factura: " + e.getMessage());
=======
            System.out.println("Factura guardada en" + fileName);
        } catch (IOException e) {
            System.out.println("Error al guardar la factura" + e.getMessage());
>>>>>>> 947e8e8b567d8ea6453ad7e427a783eeb8ea36df
        }
    }
}
