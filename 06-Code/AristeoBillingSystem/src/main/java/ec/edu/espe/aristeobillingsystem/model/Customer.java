package ec.edu.espe.aristeobillingsystem.model;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class Customer {

    private String customerId;
    private TypeOfId typeOfId;
    private String name;
    private String email;

    public Customer(String customerId, TypeOfId typeOfId, String name, String email) {
        this.customerId = customerId;
        this.typeOfId = typeOfId;
        this.name = name;
        this.email = email;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
