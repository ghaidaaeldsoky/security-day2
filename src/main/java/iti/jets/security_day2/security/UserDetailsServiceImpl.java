package iti.jets.security_day2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import iti.jets.security_day2.entity.UserEntity;
import iti.jets.security_day2.repo.UserRepo;


public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity currentUser = userRepo.findByUsername(username)
                            .orElseThrow(()-> new UsernameNotFoundException("Ops, User not found"));


         return User.withUsername(currentUser.getUsername())
                .password(currentUser.getPassword())
                .build();
    }
    
}
