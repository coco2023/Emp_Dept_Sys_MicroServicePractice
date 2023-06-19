package com.microprac.springsecurityJWT.V1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthController {

    @Autowired
    private UserDetailsService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Authenticate the user
        UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
        // Generate JWT
        String token = JwtUtils.generateToken(userDetails);
        // Return the token
        return ResponseEntity.ok(new JwtResponse(token));
    }

}
