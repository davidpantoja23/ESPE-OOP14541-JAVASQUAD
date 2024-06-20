package ec.edu.espe.billingsystem.model;

import java.util.Objects;

/**
 * Represents a payment method.
 * @author: JavaSquad, DCCO-ESPE
 */
public class PaymentMethod {
    private final int id;
    private final String name;

    public PaymentMethod(int id, String name) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "Debe seleccionar al menos un método de pago");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
