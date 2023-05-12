package model;

/**
 *
 * @author Marlon Torres
 */
public class Usuario {

    private Integer id;
    private String name, email, phone, username, password, levelType, status, register;

    public Usuario(Integer id, String name, String email, String phone, String username,
            String password, String levelType, String status, String register ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.levelType = levelType;
        this.status = status;
        this.register = register;
    }

    public Usuario(String name, String email, String phone, String username, String password, String levelType, String status, String register) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.levelType = levelType;
        this.status = status;
        this.register = register;
    }
    
    public Usuario(Integer id, String name, String username, String levelType, String status) {
        this.id = id;
        this.name = name;        
        this.username = username;
        this.levelType = levelType;
        this.status = status;
    }

    public Usuario(String username, String password, String levelType, String status) {
        this.username = username;
        this.password = password;
        this.levelType = levelType;
        this.status = status;
    }
    
    public Usuario(String username, String name_user) {
        this.name = name_user;
        this.username = username;
    }

    public Usuario(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.password = password;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }    
}
