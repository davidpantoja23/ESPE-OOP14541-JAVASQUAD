/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.billingsystem.view;

import ec.edu.espe.billingsystem.model.Product;
import ec.edu.espe.billingsystem.model.Menu;
import ec.edu.espe.billingsystem.utils.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author:  JavaSquad, DCCO-ESPE
 */
import java.util.Scanner;

public class BillingSystems {

    public static void main(String[] args) {
        printWelcome();

        try (Scanner scanner = new Scanner(System.in)) {
            int number;

            do {
                Menu.showMenu();
                number = InputUtils.getInt("Escoja una opción:");
                
                switch (number) {
                    case 1:
                        FileManager.addBilling();
                        break;
                    case 2:
                        Menu.showFoodMenu();
                        break;
                    case 3:
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } while (number != 3);
        }
    }
    
    private static void printWelcome() {
        String welcomeMessage = 
              "------------------------------------------------\n" +
              "|                                               |\n" +
              "| Bienvenido al sistema de facturación V 0.3    |\n" +
              "|                                               |\n" +
              "------------------------------------------------\n";
        System.out.println(welcomeMessage);
    }
}