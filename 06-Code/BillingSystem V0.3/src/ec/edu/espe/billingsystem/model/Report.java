
package ec.edu.espe.billingsystem.model;
import java.util.Objects;
/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */
public class Report {
    private int id;
    private String type;
    private String content;

    public Report(int id, String type, String content) {
        if (id < 0) {
            throw new IllegalArgumentException("Report ID cannot be negative");
        }
        this.id = id;
        this.type = Objects.requireNonNull(type, "Type cannot be null");
        this.content = Objects.requireNonNull(content, "Content cannot be null");
    }

    @Override
    public String toString() {
        return "Report{" + "id=" + id + ", type=" + type + ", content=" + content + '}';
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
