package ec.edu.espe.AristeoSimulator.view;

import ec.edu.espe.AristeoSimulator.controller.FileManager;
import ec.edu.espe.AristeoSimulator.model.Command;
import ec.edu.espe.AristeoSimulator.model.Customer;
import ec.edu.espe.AristeoSimulator.model.Employer;
import ec.edu.espe.AristeoSimulator.model.Inventory;
import ec.edu.espe.AristeoSimulator.model.Invoice;
import ec.edu.espe.AristeoSimulator.model.PaymentWay;
import ec.edu.espe.AristeoSimulator.model.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class AristeoSimulator {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Product product1 = new Product(1, "Ribeye", 100, (int) 0.5);
        Product product2 = new Product(2, "Tomahwak", 50, (int) 0.3);
        Product product3 = new Product(3, "Ice-Cream", 200, (int) 0.4);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        System.out.println("Initial Inventory:");
        inventory.displayInventory();
        Product item1 = new Product(1, "Pizza", 10.0, 2);
        Product item2 = new Product(2, "Soda", 2.0, 3);
        Command command = new Command(5, 21.0);
        command.addProduct(item1);
        command.addProduct(item2);
        double subtotal = command.calculateSubtotal();
        double vat = command.calculateVAT();
        double total = command.calculateTotal();

        System.out.println("Subtotal: " + subtotal);
        System.out.println("VAT: " + vat);
        System.out.println("Total: " + total);

        command.updateStatus("preparing");
        Invoice invoice = new Invoice(1, command, new Date(), subtotal, 21.0);
        PaymentWay cash = new PaymentWay(1, "Cash", 0, true);
        PaymentWay creditCard = new PaymentWay(2, "Credit Card", 2.5, true); // 2.5% transaction fee
        PaymentWay mobilePayment = new PaymentWay(3, "Mobile Payment", 1.5, false); // Not available currently

        System.out.println("Available Payment Ways:");
        System.out.println(cash);
        System.out.println(creditCard);
        System.out.println(mobilePayment);

        inventory.updateStock(1, -2); 
        inventory.updateStock(2, -3);
        System.out.println("Inventory after the command:");
        inventory.displayInventory();
    }
}
