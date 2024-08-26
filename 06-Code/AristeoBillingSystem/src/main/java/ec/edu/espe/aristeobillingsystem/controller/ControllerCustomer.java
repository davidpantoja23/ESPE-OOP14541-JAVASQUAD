/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.aristeobillingsystem.controller;

import ec.edu.espe.aristeobillingsystem.model.Customer;
import ec.edu.espe.aristeobillingsystem.model.User;
import java.util.Objects;
import javax.swing.JOptionPane;
import utils.MongoDbManager;

/**
 *
 * @author Jenniffer Marquez, JavaSquad, DCCO-ESPE
 */
public class ControllerCustomer {
    
    private static User user;
    public static void createCustomer(Customer customer){
        Objects.requireNonNull(customer, "El campo de cliente cliente no puede estar vacio.");
    }
    public static void addCustomer(Customer customer) {
        Objects.requireNonNull(customer, "El cliente no puede ser nulo.");
        try {
            MongoDbManager.addCustomer(customer); // Ensure this method exists and works
            JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void removeCustomer(String customer) {
        
    }
    
    
}
