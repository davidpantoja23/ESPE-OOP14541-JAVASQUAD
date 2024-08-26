package ec.edu.espe.aristeobillingsystem.model;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author  JavaSquad, DCCO-ESPE
 */
public class Customer {
    private String name;
    private String address;
    private int id;

    public Customer(String name, String address) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.address = Objects.requireNonNull(address, "La dirección no puede ser nula");
    }

    public Customer(String name, String address, int id) {
        this(name, address);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
