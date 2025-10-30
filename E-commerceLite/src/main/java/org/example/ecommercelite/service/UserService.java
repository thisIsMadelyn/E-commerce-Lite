package org.example.ecommercelite.service;

import org.example.ecommercelite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.example.ecommercelite.enity.User;

// κανονικα πρεπει να λεει enTity αλλα εχω γραψει
// enity σε ολο το project για να μην χαλασει τιποτα
// οτι νανε

// @Service annotation indicates that this class
// is a service component in the Spring framework
@Service
public class UserService {

//    repository dependency used to acccess
//    the database. it is injected by Spring
//    constructor injection
    @Autowired
    private final UserRepository userRepository;

//    constructor - receives UserRepository instance
//    and assigns it to the userRepository field
//    so the service can see it
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    calls the findAll method of the UserRepository
//    and returns the complete list of User enities
//    from the database
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    Calls userRepository.save(user) to persist
//    the passed User entity.
//    Returns the saved entity (typically with
//    generated id and any DB-managed fields such
//    as creation timestamp populated).
//    Note: email uniqueness is enforced by
//    the DB/column constraint, saving a duplicate
//    email will throw a persistence exception.
    public User createUser(User user) {
        return userRepository.save(user);
    }

//    Calls userRepository.findByEmail(email)
//    and returns an Optional<User>.
//    Optional may contain the found user or
//    be empty if no user with that email exists.
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

//    to delete a user by id
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

//     checks if a user with the given id exists
    public boolean userExists(Integer id) {
        return userRepository.existsById(id);
    }

/*    What this service does :
        - Buisness Logic Layer: Contains the core application
          logic related to User entities.
        - Bridge Between Controller and Repository:
          Acts as an intermediary between the web layer
          (controllers) and the data access layer (repositories).
        - Future-proof: you can add validation, email checks, etc. here later


 */

}
