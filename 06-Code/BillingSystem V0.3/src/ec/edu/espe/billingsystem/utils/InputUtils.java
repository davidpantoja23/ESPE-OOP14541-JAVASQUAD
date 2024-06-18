/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.billingsystem.utils;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */
import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor ingrese un número entero.");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return value;
    }

    public static String getString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static boolean getBoolean(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim().toLowerCase(); // Lee la entrada del usuario y la convierte a minúsculas

        if (input.equals("si") || input.equals("sí") || input.equals("verdadero")) {
            return true;
        } else if (input.equals("no") || input.equals("falso")) {
            return false;
        } else {
            System.out.println("Respuesta no válida, por favor ingrese 'si' o 'no'.");
            return getBoolean(prompt); // Vuelve a solicitar la entrada si no es válida
        }
    }

    public static double getDouble(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor ingrese un número decimal.");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        return value;
    }
}
