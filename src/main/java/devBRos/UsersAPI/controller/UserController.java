/*  UserController.java - REST_API_Users - Code challenge for ThinkOn
**  Controller class to User model/entity
**  Guilherme de Goes Oliveira Lopes
**
**  Revision History
**      Guilherme Lopes, 2024.10.10: Created


    Route               Method      Functionality
------------------------------------------------------------
    /api/users          GET         get all users
    /api/users          POST        create a new user
    /api/users/{id}     GET         get a user by id
    /api/users/{id}     PUT         update a user by id
    /api/users/{id}     DELETE      delete a user by id
------------------------------------------------------------
*/

package devBRos.UsersAPI.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devBRos.UsersAPI.entity.User;
import devBRos.UsersAPI.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    // route to GET method for URL: "/api/users" - get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // route to GET method for URL: "/api/users/{id}" - get a user by id
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // route to GET method for URL: "/api/users/email/{email}" - get a user by email
    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // route to POST method for URL: "/api/users" - create a new user 
    @PostMapping
    public User creatUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // route to PU method for URL: "/api/users/{id}" - update a user by id
    @PutMapping("/{id}")
    public User updatUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    // route to DELETE method for URL: "/api/users/{id}" - delete a user by id
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
