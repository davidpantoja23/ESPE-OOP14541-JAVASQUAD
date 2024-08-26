package ec.edu.espe.aristeobillingsystem.model;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class PaymentMethod {
    private String methodType;
    private String details;

    public PaymentMethod(String methodType, String details) {
        validateMethodType(methodType);
        this.methodType = methodType;
        this.details = details;
    }

    private void validateMethodType(String methodType) {
        if (methodType == null || methodType.isEmpty()) {
            throw new IllegalArgumentException("El tipo de método de pago no puede ser nulo o vacío.");
        }
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        validateMethodType(methodType);
        this.methodType = methodType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}