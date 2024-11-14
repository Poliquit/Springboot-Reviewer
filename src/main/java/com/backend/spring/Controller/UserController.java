
package com.backend.spring.Controller;

import com.backend.spring.Entity.Users;
import com.backend.spring.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/membership")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/list")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public List<Users> createUser(@RequestBody List<Users> user) {
        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
