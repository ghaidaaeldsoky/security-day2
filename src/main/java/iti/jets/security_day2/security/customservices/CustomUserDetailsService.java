package iti.jets.security_day2.security.customservices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import iti.jets.security_day2.entity.UserEntity;
import iti.jets.security_day2.repo.UserRepo;



public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Get User From DB
        UserEntity currentUser = userRepo.findByUsername(username)
                            .orElseThrow(()-> new UsernameNotFoundException("Ops, User not found"));

        // Get User Autorities                    
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add( new SimpleGrantedAuthority( currentUser.getRole()));

        // return User Details
        return User.withUsername(currentUser.getUsername())
                .password(currentUser.getPassword())
                .roles(currentUser.getRole().replace("ROLE_", ""))
                .build();
    }
    
}
