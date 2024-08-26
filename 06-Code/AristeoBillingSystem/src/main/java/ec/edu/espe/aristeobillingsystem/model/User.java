package ec.edu.espe.aristeobillingsystem.model;

import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author Jenniffer Marquez, JavaSquad, DCCO-ESPE
 */
public class User {
    private String username;
    private String password;  
    private String role;      

    public User(String username, String password, String role) {
        this.username = username;
        this.password = encryptPassword(password);  
        this.role = role;
    }

    private String encryptPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public boolean verifyPassword(String plainPassword) {
        return BCrypt.checkpw(plainPassword, this.password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = encryptPassword(password);  
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAdmin() {
        return "Admin".equalsIgnoreCase(this.role);
    }

    public boolean isCajero() {
        return "Cajero".equalsIgnoreCase(this.role);
    }
}

