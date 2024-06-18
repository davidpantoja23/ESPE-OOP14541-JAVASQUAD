
package ec.edu.espe.billingsystem.utils;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */

public class IVACalculator {
    private static final double IVA_RATE = 0.15;

    public static double calculateIVA(double subtotal) {
        if (subtotal < 0) {
<<<<<<< HEAD
            throw new IllegalArgumentException("El subtotal debe ser un valor positivo");
=======
            throw new IllegalArgumentException("El subtotal no puede ser negativo");
>>>>>>> 947e8e8b567d8ea6453ad7e427a783eeb8ea36df
        }
        return subtotal * IVA_RATE;
        
    }
}


