
package ec.edu.espe.billingsystem.model;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */
public class PaymentMethod {
    private int id;
    private String name;

    public PaymentMethod(int id, String name) {
        this.id = id;
        this.name = name;
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