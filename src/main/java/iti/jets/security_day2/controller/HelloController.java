package iti.jets.security_day2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    


    @GetMapping("/home")
    public String getHomePage() {
        return new String("Home Page");
    }
    
    @GetMapping("/admin/home")
    public String adminPanel() {
        return "Welcome Admin Home !";
    }
    
}
