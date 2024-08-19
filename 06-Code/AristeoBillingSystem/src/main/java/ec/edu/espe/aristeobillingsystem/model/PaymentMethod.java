package ec.edu.espe.aristeobillingsystem.model;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class PaymentMethod {
    private String methodType;
    private String details;

    public PaymentMethod(String methodType, String details) {
        this.methodType = methodType;
        this.details = details;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}