
package ec.edu.espe.billingsystem.model;

import java.util.Scanner;

/**
 *
 * @author JavaSquad, DCCO-ESPE
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public TypeOfId getTypeOfId() {
        return typeOfId;
    }

    public void setTypeOfId(TypeOfId typeOfId) {
        this.typeOfId = typeOfId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
<<<<<<< HEAD

    AbstractStringBuilder getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
=======
}
>>>>>>> 6215c0107f4ddb8df1c725b2abcdd92ba03c4741
