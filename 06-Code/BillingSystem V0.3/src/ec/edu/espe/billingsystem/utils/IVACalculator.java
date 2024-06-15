
package ec.edu.espe.billingsystem.utils;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */

public class IVACalculator {
    private static final double IVA_RATE = 0.15;

    public static double calculateIVA(double subtotal) {
        return subtotal * IVA_RATE;
        
    }
}


