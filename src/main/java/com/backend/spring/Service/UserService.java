
package com.backend.spring.Service;

import com.backend.spring.Entity.Users;
import com.backend.spring.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Create User
    public List<Users> createUser(List<Users> user) {
        return userRepository.saveAll(user);
    }
    
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    
    // Update user by Id
    public Users updateUser(Long id, Users updatedUser) {
        Users existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setName(updatedUser.getName());
        return userRepository.save(existingUser);
    }
    
    // Delete user by ID
    public void deleteUser(Long id) {
        Users existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(existingUser);
    }
}
