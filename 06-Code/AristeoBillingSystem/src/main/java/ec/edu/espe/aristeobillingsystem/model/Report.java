package ec.edu.espe.aristeobillingsystem.model;

import java.util.Objects;

/**
 *
 * @author David Morillo, JavaSquad, DCCO-ESPE
 */
public class Report {

    private int id;
    private String type;
    private String content;

    public Report(int id, String type, String content) {
        validateReportDetails(id, type, content);
        this.id = id;
        this.type = type;
        this.content = content;
    }

    private void validateReportDetails(int id, String type, String content) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID del informe no puede ser negativo.");
        }
        Objects.requireNonNull(type, "El tipo no puede ser nulo.");
        Objects.requireNonNull(content, "El contenido no puede ser nulo.");
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
}
