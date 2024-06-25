
package ec.edu.espe.billingsystem.utils;

/**
 * @author: JavaSquad, DCCO-ESPE
 */
public class IVACalculator {
    private static final double IVA_RATE = 0.15;

    /**
     * Calculates the IVA based on the given subtotal.
     *
     * @param subtotal The subtotal amount.
     * @return The calculated IVA amount.
     * @throws IllegalArgumentException If the subtotal is negative.
     */
    public static double calculateIVA(double subtotal) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("El subtotal no puede ser negativo");
        }
        return subtotal * IVA_RATE;
    }
}


