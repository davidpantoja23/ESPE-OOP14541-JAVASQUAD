package ec.edu.espe.aristeobillingsystem.model;

import java.util.Objects;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class Report {

    private int id;
    private String type;
    private String content;
    private PaymentMethod paymentMethod;

    public Report(int id, String type, String content, PaymentMethod paymentMethod) {
        validateReportDetails(id, type, content);
        this.id = id;
        this.type = type;
        this.content = content;
        this.paymentMethod = Objects.requireNonNull(paymentMethod, "El método de pago no puede ser nulo.");
    }

    private void validateReportDetails(int id, String type, String content) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID del informe no puede ser negativo.");
        }
        Objects.requireNonNull(type, "El tipo no puede ser nulo.");
        Objects.requireNonNull(content, "El contenido no puede ser nulo.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = Objects.requireNonNull(paymentMethod, "El método de pago no puede ser nulo.");
    }
}