/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.billingsystem.view;

import ec.edu.espe.billingsystem.model.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */
public class BillingSystems {
    public static void main(String[] args) {
     int number=0;
    do {
     System.out.println("Program startup \n1: Data entry \n2:Food menu \n3: Exit");
        number =Integer.parseInt(System.console().readLine());
    switch(number){
        case 1:
        FileManager.addBilling();
        break;
        case 2:
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Pizza", 5.99, 100));
        products.add(new Product(2, "Fries", 2.99, 200));
        products.add(new Product(3, "Soda", 1.49, 300));
        for (Product product : products) {
        System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
        }
        break;
        case 3:
        break;
        default:   
       System.out.println("Invalid option");
    }
    
    
    }while(number!=3);   
    }
}
