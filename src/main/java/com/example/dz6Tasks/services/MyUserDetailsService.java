package com.example.dz6Tasks.services;

import com.example.dz6Tasks.models.MyUserDetails;
import com.example.dz6Tasks.models.User;
import com.example.dz6Tasks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        return user.map(MyUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

}
