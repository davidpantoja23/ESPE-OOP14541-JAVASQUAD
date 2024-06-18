
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

    public Customer(String id, String name, String email) {

        this.id = id;
        this.name = name;
        this.email = email;

        
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
        return "Customer{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
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

    
}

    