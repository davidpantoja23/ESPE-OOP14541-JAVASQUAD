package ec.edu.espe.aristeobillingsystem.model;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class User {

    private String username;
    private String password;
    private ArrayList<Customer> customers;

    public User(String username, String password, ArrayList<Customer> customesr) {
        this.username = username;
        this.password = password;
        this.customers = customesr;
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    
    public void removeCustomer(String dni) {
        customers.removeIf(c -> c.getDni().equals(dni));
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the customesr
     */
    public ArrayList<Customer> getCustomesr() {
        return customers;
    }

    /**
     * @param customesr the customesr to set
     */
    public void setCustomesr(ArrayList<Customer> customesr) {
        this.customers = customesr;
    }
    

    
}
