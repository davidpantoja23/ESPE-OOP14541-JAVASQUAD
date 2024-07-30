/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.aristeobillingsystem.controller;

import ec.edu.espe.aristeobillingsystem.model.Customer;
import ec.edu.espe.aristeobillingsystem.model.User;
import java.util.Objects;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class ControllerCustomer {
    
    private static User user;
    public static void createCustomer(Customer customer){
        Objects.requireNonNull(customer, "El producto no puede ser nulo.");
        user.addCustomer(customer);
    }
    
    public void removeCustomer(String customer) {
        user.removeCustomer(customer);
    }
}
