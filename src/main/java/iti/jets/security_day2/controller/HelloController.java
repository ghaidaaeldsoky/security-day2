package iti.jets.security_day2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    


    @GetMapping("/home")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String getHomePage() {
        return new String("Home Page");
    }
    
    @GetMapping("/admin/home")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminPanel() {
        return "Welcome Admin Home !";
    }
    
}
