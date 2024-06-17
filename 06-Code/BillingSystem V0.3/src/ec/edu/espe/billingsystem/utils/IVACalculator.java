
package ec.edu.espe.billingsystem.utils;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */

public class IVACalculator {
    private static final double IVA_RATE = 0.12;

    public static double calculateIVA(double subtotal) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("Subtotal cannot be negative");
        }
        return subtotal * IVA_RATE;
        
    }
}


