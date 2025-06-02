package iti.jets.security_day2.controller;

import org.springframework.web.bind.annotation.RestController;

import iti.jets.security_day2.dtos.JwtResponse;
import iti.jets.security_day2.dtos.LoginDto;
import iti.jets.security_day2.services.AuthServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HelloController {
    
    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginDto loginDto){

        String token = authService.login(loginDto);

        JwtResponse jwtAuthResponse = new JwtResponse();
        jwtAuthResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }


    @GetMapping("/home")
    // @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String getHomePage() {
        return new String("Home Page");
    }
    
    @GetMapping("/admin/home")
    // @PreAuthorize("hasRole('ADMIN')")
    public String adminPanel() {
        return "Welcome Admin Home !";
    }
    
}
