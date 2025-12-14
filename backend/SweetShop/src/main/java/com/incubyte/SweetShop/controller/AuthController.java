package com.incubyte.SweetShop.controller;

import com.incubyte.SweetShop.dto.LoginRequest;
import com.incubyte.SweetShop.dto.RegisterRequest;
import com.incubyte.SweetShop.entity.User;
import com.incubyte.SweetShop.repository.UserRepository;
import com.incubyte.SweetShop.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        return jwtUtil.generateToken(request.getUsername());
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        Optional<User> existingUser =
                userRepository.findByUsername(request.getUsername());

        if (existingUser.isPresent()) {
            return "Username already taken";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        return "User registered successfully";
    }
}
