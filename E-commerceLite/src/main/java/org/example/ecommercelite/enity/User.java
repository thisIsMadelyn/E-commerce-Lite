package org.example.ecommercelite.enity;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "users")
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
