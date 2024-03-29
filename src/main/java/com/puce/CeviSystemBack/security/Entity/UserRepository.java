package com.puce.CeviSystemBack.security.Entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username); 
    boolean existsByCorreoElectronico(String correoElectronico); 
}
