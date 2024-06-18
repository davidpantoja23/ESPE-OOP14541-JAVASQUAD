/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.AristeoSimulator.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class Invoice {
    private int id;
    private Date date;
    private Customer customer;
    private List<InvoiceItem> items;
    private double total;

    public Invoice(int id, Command command, Date date, double total, double par1) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.items = items;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + id + ", date=" + date + ", customer=" + customer + ", items=" + items + ", total=" + total + '}';
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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the items
     */
    public List<InvoiceItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
}
