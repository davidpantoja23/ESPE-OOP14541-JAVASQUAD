
package ec.edu.espe.billingsystem.model;

/**
 *
 * @author David Pantoja, JavaSquad, DCCO-ESPE
 */
public class Report {
    private int id;
    private String type;
    private String content;

    public Report(int id, String type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
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
