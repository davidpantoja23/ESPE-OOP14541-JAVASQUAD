/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.AristeoSimulator.model;

import java.util.List;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class BillingSystem {
    private int id;
    private int time;
    private List<Customer> customers;
    private List<Product> products;

    public BillingSystem(int id, int time, List<Customer> customers, List<Product> products) {
        this.id = id;
        this.time = time;
        this.customers = customers;
        this.products = products;
    }

    @Override
    public String toString() {
        return "BillingSystem{" + "id=" + id + ", time=" + time + ", customers=" + customers + ", products=" + products + '}';
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * @return the customers
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * @param customers the customers to set
     */
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    /**
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
