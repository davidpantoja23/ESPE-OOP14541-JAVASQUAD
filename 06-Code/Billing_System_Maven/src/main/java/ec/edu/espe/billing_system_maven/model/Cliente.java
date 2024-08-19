
package ec.edu.espe.billing_system_maven.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.bson.Document;

/**
 *
 * @author Javasquad, DCCO-ESPE
 */
public class Cliente {

    private String nombre;
    private String apellido;
    private String id;
    private String email;
    private String telefono;
    private LocalDateTime fechaVisita;
    private int visitas;

    public Cliente(String nombre, String apellido, String id, String email, String telefono, LocalDateTime fechaVisita, int visitas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.email = email;
        this.telefono = telefono;
        this.fechaVisita = fechaVisita;
        this.visitas = visitas;
    }

    
    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the fechaVisita
     */
    public LocalDateTime getFechaVisita() {
        return fechaVisita;
    }

    /**
     * @param fechaVisita the fechaVisita to set
     */
    public void setFechaVisita(LocalDateTime fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    /**
     * @return the visitas
     */
    public int getVisitas() {
        return visitas;
    }

    /**
     * @param visitas the visitas to set
     */
    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }
    
    public Document toDocument() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return new Document("nombre", this.nombre)
                .append("apellido", this.apellido)
                .append("id", this.id)
                .append("email", this.email)
                .append("telefono", this.telefono)
                .append("visitas", this.visitas)
                .append("fechaVisita", this.fechaVisita.format(formatter));
    }
}
