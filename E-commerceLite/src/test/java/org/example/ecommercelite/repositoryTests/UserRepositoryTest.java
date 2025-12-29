package org.example.ecommercelite.repositoryTests;


import org.example.ecommercelite.enity.User;
import org.example.ecommercelite.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    public void check_If_User_Exists_By_Email(){

//        Arrange

        String email = "example@gmail.com";
        User user = new User("Doe",email);

//        Act

//        test: saving the user
        User savedUser = userRepository.save(user);

//        tset: finding the user by email
        Optional<User> exists = userRepository.findByEmail(email);

//        Assert

        assertTrue(exists.isPresent());
        assertEquals(email, exists.get().getEmail(), "the email was successfully retrieved from the DataBase");

    }

    @Test
    public void it_Should_Return_Empty_When_Email_Does_Not_Exist(){

//        Arrange

        String email = "hello@world.com";

//        Act

        Optional <User> exists = userRepository.findByEmail(email);

//        Assert
        assertTrue(exists.isEmpty());
    }

    @Test
    public void UserRepository_GetAll_Return_More_Than_One(){

        User user1 = new User("Smith","smith@gmail.com");
        User user2 = new User("Sparrow", "sparrow@gmail.com");

        userRepository.save(user1);
        userRepository.save(user2);

        List<User> userList = userRepository.findAll();

        Assertions.assertNotNull(userList, "The user list shouldnt be null");
        Assertions.assertEquals(2,userList.size(), "The DB should contain 2 users");

    }
}
