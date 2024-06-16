/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.billingsystem.view;
import ec.edu.espe.billingsystem.model.Product;
import ec.edu.espe.billingsystem.utils.InputUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */
public class BillingSystems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        
        do {
            showMenu();
            number = InputUtils.getInt("Choose an option:");
            
            switch (number) {
                case 1:
                    FileManager.addBilling();
                    break;
                case 2:
                    showFoodMenu();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (number != 3);
        
        scanner.close();
    }
    
    private static void showMenu() {
        System.out.println("Program startup");
        System.out.println("1: Data entry");
        System.out.println("2: Food menu");
        System.out.println("3: Exit");
    }

    private static void showFoodMenu() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Pizza", 5.99, 100));
        products.add(new Product(2, "Fries", 2.99, 200));
        products.add(new Product(3, "Soda", 1.49, 300));
        
        for (Product product : products) {
            System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
        }
    }
}
