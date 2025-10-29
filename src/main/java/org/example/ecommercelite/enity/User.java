package org.example.ecommercelite.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lastName;

    @Column(unique = true/*, nullable = false*/)
    private String email;

    @CreationTimestamp
    @Column(name = "created_at", /*nullable = false,*/ updatable = false)
    private LocalDateTime createdAt;

    //    Constructors
    public User() {}

    public User(String lastName, String email) {
        this.lastName = lastName;
        this.email = email;
    }

//    getters and setters

    public Integer getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
