package org.example.ecommercelite.repository;

import org.example.ecommercelite.enity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository< User,Integer> {
    // Spring will automatically implement this method based on its name
    Optional<User> findByEmail(String email);
}
