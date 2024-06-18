
package ec.edu.espe.billingsystem.model;
import java.util.Objects;
/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */
public class PaymentMethod {
    private int id;
    private String name;

    public PaymentMethod(int id, String name) {
        this.id = id;
<<<<<<< HEAD
        this.name = Objects.requireNonNull(name, "Debe seleccionar al menos un método de pago");
=======
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
>>>>>>> 947e8e8b567d8ea6453ad7e427a783eeb8ea36df
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
