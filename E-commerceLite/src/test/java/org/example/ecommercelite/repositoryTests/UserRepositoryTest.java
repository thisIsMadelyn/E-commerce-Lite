package org.example.ecommercelite.repositoryTests;


import org.example.ecommercelite.enity.User;
import org.example.ecommercelite.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    public void check_If_User_Exists_By_Email(){

//        Arrange

        String email = "example@gmail.com";
        User user = new User("Doe",email);
        userRepository.save(user);

//        Act

        Optional<User> exists = userRepository.findByEmail(email);

//        Assert

        assertTrue(exists.isPresent());
        assertEquals(email, exists.get().getEmail());

    }

    @Test
    public void it_Should_Return_Empty_When_Email_Does_Not_Exists(){

        String email = "hello@world.com";

        Optional <User> exists = userRepository.findByEmail(email);

        assertTrue(exists.isEmpty());
    }
}
