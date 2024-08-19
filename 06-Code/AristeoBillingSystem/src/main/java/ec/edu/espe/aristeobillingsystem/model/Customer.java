package ec.edu.espe.aristeobillingsystem.model;

import java.util.UUID;

/**
 *

/**
 *
 * @author  JavaSquad, DCCO-ESPE
 */
public class Customer {
    private String name;
    private String address;
    private int id;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
}
