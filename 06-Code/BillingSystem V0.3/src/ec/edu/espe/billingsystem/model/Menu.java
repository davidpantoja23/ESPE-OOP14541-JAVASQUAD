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
import java.util.ArrayList;
import java.util.List;

public class Menu {

    public static void showMenu() {
        String menu = 
              "--------------------------------------\n" +
              "|         Inicio del programa         |\n" +
              "--------------------------------------\n" +
              "| 1: Ingreso de datos                 |\n" +
              "| 2: Menú Aristeo                     |\n" +
              "| 3: Salir del programa               |\n" +
              "--------------------------------------";
        System.out.println(menu);
    }

    public static void showFoodMenu() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Hamburguesa 1/2", 5.99, 100));
        products.add(new Product(2, "Porción de papas", 2.99, 200));
        products.add(new Product(3, "Gaseosa litro", 2.00, 300));
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

        StringBuilder foodMenu = new StringBuilder();
        foodMenu.append("--------------------------------------\n")
                .append("|             Menú Aristeo           |\n")
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
}
