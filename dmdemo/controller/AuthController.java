package com.document.dmdemo.controller;

import com.document.dmdemo.dto.AuthRequest;
import com.document.dmdemo.serviceImpl.UserInfoService;
import com.ey.springboot3security.service.JwtService;
import com.ey.springboot3security.service.UserInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserInfoService userInfoService;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, UserInfoService userInfoService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userInfoService = userInfoService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
        );

        UserDetails userDetails = userInfoService.loadUserByUsername(authRequest.getEmail());
        String jwtToken = jwtService.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(jwtToken);
    }
}