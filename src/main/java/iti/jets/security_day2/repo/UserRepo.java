package iti.jets.security_day2.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import iti.jets.security_day2.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long>{
    
    public Optional<UserEntity> findByUsername(String username);

}
