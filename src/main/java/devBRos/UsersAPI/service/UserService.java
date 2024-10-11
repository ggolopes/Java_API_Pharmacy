/*  UserService.java - REST_API_Users - Code challenge for ThinkOn
**  UserService class to User model/entity 
**  Guilherme de Goes Oliveira Lopes
**
**  Revision History
**      Guilherme Lopes, 2024.10.10: Created
*/

package devBRos.UsersAPI.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devBRos.UsersAPI.entity.User;
import devBRos.UsersAPI.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // get a user by id
    public Optional<User> getUserById(Long id) {
        return  userRepository.findById(id);
    }

    // get a user by email
    public  Optional<User> getUserByEmail (String email) {
        return userRepository.findByEmail(email);
    }

    // create a new user
    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("email already used");
        }
        return userRepository.save(user);
    }

    // update a user by id
    public User updateUser (Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDetails.getUsername());
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        return userRepository.save(user);
    }

    // update a user by email
    public User updateUser (String email, User userDetails) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDetails.getUsername());
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        return userRepository.save(user);
    }

    // delete a user by id
    public void deleteUser (Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    // delete a user by email
    public void deleteUser (String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

}
