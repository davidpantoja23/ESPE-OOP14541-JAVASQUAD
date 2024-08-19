package ec.edu.espe.aristeobillingsystem.model;

import java.util.UUID;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class Customer {

    private String dni;
    private String name;
    private String email; 
    private String phone;

    public Customer(String dni, String name, String email, String phone) {
        this.dni = dni;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
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
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
