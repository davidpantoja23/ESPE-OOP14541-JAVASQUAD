package ec.edu.espe.aristeobillingsystem.model;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author  JavaSquad, DCCO-ESPE
 */
public class Customer {
    private String dni;         
    private String name;        
    private String email;       
    private String phone;       

    public Customer(String dni, String name, String email, String phone) {
        this.dni = Objects.requireNonNull(dni, "El DNI no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.email = Objects.requireNonNull(email, "El correo electrónico no puede ser nulo");
        this.phone = Objects.requireNonNull(phone, "El teléfono no puede ser nulo");
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
