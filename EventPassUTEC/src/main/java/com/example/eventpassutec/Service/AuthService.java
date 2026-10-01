package com.example.eventpassutec.Service;

import com.example.eventpassutec.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtservice, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtservice;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;

    }

    @Transactional
    public UserResponse
}
