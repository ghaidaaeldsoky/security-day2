package iti.jets.security_day2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String gmail;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    // Constructors
    public UserEntity() {
    }

    public UserEntity(String username, String gmail, String password) {
        this.username = username;
        this.gmail = gmail;
        this.password = password;
    }

    public UserEntity(String username, String gmail, String password, String role) {
    this.username = username;
    this.gmail = gmail;
    this.password = password;
    this.role = role;
}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }


}
