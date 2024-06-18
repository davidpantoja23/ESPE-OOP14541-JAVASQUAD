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
 * Author: David Pantoja, JavaSquad, DCCO-ESPE
 */
public class BillingSystems {
    public static void main(String[] args) {
        printWelcome();

        try (Scanner scanner = new Scanner(System.in)) {
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
        }
    }
    
    private static void printWelcome() {
        String programName = "Welcome to the Billing System V 0.3";
        String welcomeMessage = 
              "------------------------------------------------\n" +
              "|                                               |\n" +
             // "|     " + centerText(programName, 24) + "       |\n" +
              "|                                               |\n" +
              "------------------------------------------------\n";
        System.out.println(welcomeMessage);
    }

    private static void showMenu() {
        String menu = 
              "--------------------------------------\n" +
              "|           Program startup           |\n" +
              "--------------------------------------\n" +
              "| 1: Data entry                       |\n" +
              "| 2: Food menu                        |\n" +
              "| 3: Exit the Program                 |\n" +
              "--------------------------------------";
        System.out.println(menu);
    }

    private static void showFoodMenu() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Pizza", 5.99, 100));
        products.add(new Product(2, "Fries", 2.99, 200));
        products.add(new Product(3, "Soda", 1.49, 300));
        products.add(new Product(4, "Burger", 4.99, 150));
        products.add(new Product(5, "Salad", 3.99, 80));
        products.add(new Product(6, "Chicken Sandwich", 5.49, 120));
        products.add(new Product(7, "Ice Cream", 2.49, 90));
        products.add(new Product(8, "Coffee", 1.99, 200));
        products.add(new Product(9, "Tea", 1.49, 250));
        products.add(new Product(10, "Milkshake", 3.49, 70));

        StringBuilder foodMenu = new StringBuilder();
        foodMenu.append("--------------------------------------\n")
                .append("|             Food Menu               |\n")
                .append("--------------------------------------\n");

        for (Product product : products) {
            String productInfo = product.getId() + ": " + product.getName() + " - $" + product.getPrice();
            foodMenu.append("| ")
                    .append(String.format("%-36s", productInfo))
                    .append("|\n");
        }

        foodMenu.append("--------------------------------------");
        System.out.println(foodMenu);
    }

   //** private static String centerText(String text, int width) {
       // if (text.length() >= width) {
         //   return text;
        //}
        //int leftPadding = (width - text.length()) / 2;
        //int rightPadding = width - text.length() - leftPadding;
        //return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }
//}
//