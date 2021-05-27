package pl.entity;

import org.apache.commons.validator.routines.EmailValidator;

public class User {

    private int id = 0;
    private String email;
    private String username;
    private String password;


    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String username,String email) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public User(int id, String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        if (ValidateEmail(email)) {
            return email;
        } else {
            System.out.println("Invalid e-mail address format");
            return null;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        //if (ValidateEmail(email)) {
            this.email = email;
        //} else {
           // throw new IllegalArgumentException("Invalid e-mail address format. E-mail could not be saved");
       // }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean ValidateEmail(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User: " +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

