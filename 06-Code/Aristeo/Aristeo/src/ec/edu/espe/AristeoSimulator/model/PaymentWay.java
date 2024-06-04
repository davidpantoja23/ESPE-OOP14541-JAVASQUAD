/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.AristeoSimulator.model;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class PaymentWay {
    private int id;
    private String type; // "Cash", "Credit Card", "Mobile Payment"
    private double transactionFee;
    private boolean available;

    public PaymentWay(int id, String type, double transactionFee, boolean available) {
        this.id = id;
        this.type = type;
        this.transactionFee = transactionFee;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double calculateTotalWithFee(double amount) {
        return amount + (amount * transactionFee / 100);
    }

    @Override
    public String toString() {
        return "PaymentWay{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", transactionFee=" + transactionFee +
                ", available=" + available +
                '}';
    }
}
