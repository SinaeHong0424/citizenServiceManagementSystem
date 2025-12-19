package com.government.serviceportal.service;

import com.government.serviceportal.dto.AuthDto;
import com.government.serviceportal.entity.User;
import com.government.serviceportal.exception.ResourceAlreadyExistsException;
import com.government.serviceportal.repository.UserRepository;
import com.government.serviceportal.security.JwtTokenProvider;
import com.government.serviceportal.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String registerUser(AuthDto.RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("Error: Email is already in use!");
        }

        User.Role role;
        try {
            role = (request.getRole() != null) ? 
                   User.Role.valueOf(request.getRole().toUpperCase()) : 
                   User.Role.CITIZEN;
        } catch (IllegalArgumentException e) {
            role = User.Role.CITIZEN;
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);

        userRepository.save(user);

        return "User registered successfully!";
    }

    public AuthDto.JwtResponse loginUser(AuthDto.LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String role = userDetails.getAuthorities().stream()
                .findFirst()
                .map(item -> item.getAuthority())
                .orElse("ROLE_CITIZEN");

        return new AuthDto.JwtResponse(jwt, userDetails.getEmail(), role);
    }
}