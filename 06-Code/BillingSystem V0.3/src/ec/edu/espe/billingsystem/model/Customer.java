
package ec.edu.espe.billingsystem.model;

import java.util.Scanner;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */
public class Customer {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;

    public Customer(String id, String name, String email, String phoneNumber) {
        
        Scanner scanner = new Scanner(System.in);

        while (id.length() != 10 || !id.chars().allMatch(Character::isDigit)) {
            System.out.println("Enter ID (must be exactly 10 digits):");
            id = scanner.nextLine();
        }


        scanner.close();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + '}';
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}

    