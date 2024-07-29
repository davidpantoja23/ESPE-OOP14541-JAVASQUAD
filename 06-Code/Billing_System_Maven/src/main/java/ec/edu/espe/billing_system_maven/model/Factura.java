
package ec.edu.espe.billing_system_maven.model;

import org.bson.Document;

/**
 *
 * @author Javasquad, DCCO-ESPE
 */
public class Factura {
    private String numeroFactura;
    private String cliente;
    private String fecha;

    public Factura(String numeroFactura, String cliente, String fecha) {
        this.numeroFactura = numeroFactura;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    /**
     * @return the numeroFactura
     */
    public String getNumeroFactura() {
        return numeroFactura;
    }

    /**
     * @param numeroFactura the numeroFactura to set
     */
    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public Document toDocument() {
        return new Document("numeroFactura", this.numeroFactura)
                .append("cliente", this.cliente)
                .append("fecha", this.fecha);
    }
}
