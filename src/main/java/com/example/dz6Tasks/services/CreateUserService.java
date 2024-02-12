package com.example.dz6Tasks.services;

import com.example.dz6Tasks.models.User;
import com.example.dz6Tasks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user) {
        userRepository.save(user);
    }
    public void creatNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        save(user);
    }
    public User getUserById(Long id){
        return userRepository.findUserById(id);
    }
}
