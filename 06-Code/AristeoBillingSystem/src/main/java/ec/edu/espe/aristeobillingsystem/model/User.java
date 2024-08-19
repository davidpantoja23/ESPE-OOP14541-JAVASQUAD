package ec.edu.espe.aristeobillingsystem.model;

import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author 
 */
public class User {
    private String username;
    private String password;  // Este será almacenado encriptado
    private String role;      // Puede ser "Admin" o "Cajero"

    // Constructor
    public User(String username, String password, String role) {
        this.username = username;
        this.password = encryptPassword(password);  // Encripta la contraseña al crear el usuario
        this.role = role;
    }

    // Método para encriptar la contraseña
    private String encryptPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Método para verificar la contraseña
    public boolean verifyPassword(String plainPassword) {
        return BCrypt.checkpw(plainPassword, this.password);
    }

    // Getters y Setters
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
        this.password = encryptPassword(password);  // Encripta la nueva contraseña
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Método adicional para verificar el rol
    public boolean isAdmin() {
        return "Admin".equalsIgnoreCase(this.role);
    }

    public boolean isCajero() {
        return "Cajero".equalsIgnoreCase(this.role);
    }
}

