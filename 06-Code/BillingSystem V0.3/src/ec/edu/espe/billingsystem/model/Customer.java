
package ec.edu.espe.billingsystem.model;

import java.util.Scanner;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */
public class Customer {
    private String id;
    private TypeOfId typeOfId;
    private String name;
    private String email;

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", typeOfId=" + typeOfId + ", name=" + name + ", email=" + email + '}';
    }

    public Customer(String id, TypeOfId typeOfId, String name, String email) {
        this.id = id;
        this.typeOfId = typeOfId;
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

    /**
     * @return the typeOfId
     */
    public TypeOfId getTypeOfId() {
        return typeOfId;
    }

    /**
     * @param typeOfId the typeOfId to set
     */
    public void setTypeOfId(TypeOfId typeOfId) {
        this.typeOfId = typeOfId;
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

    
}