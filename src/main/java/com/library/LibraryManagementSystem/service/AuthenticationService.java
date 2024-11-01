package com.library.LibraryManagementSystem.service;

import com.library.LibraryManagementSystem.dao.RoleRepository;
import com.library.LibraryManagementSystem.dao.UserRepository;
import com.library.LibraryManagementSystem.model.Role;
import com.library.LibraryManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String username, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setAuthorities(authorities);
        userRepository.save(user);
        return user;
    }
}
