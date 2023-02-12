package com.ronjeanfrancois.budget.controller;

import com.ronjeanfrancois.budget.dto.AuthResponseDto;
import com.ronjeanfrancois.budget.dto.LoginDto;
import com.ronjeanfrancois.budget.dto.RegisterDto;
import com.ronjeanfrancois.budget.model.Role;
import com.ronjeanfrancois.budget.model.UserEntity;
import com.ronjeanfrancois.budget.repository.RoleRepository;
import com.ronjeanfrancois.budget.repository.UserRepository;
import com.ronjeanfrancois.budget.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder encoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder, JWTGenerator jwtGenerator){
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDto(token),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        if(userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!",HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(encoder.encode(registerDto.getPassword()));

        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
}
