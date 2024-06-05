package com.quindinzao.petaz.repository;

import com.quindinzao.petaz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByPassword(String password);
    boolean existsByEmail(String email);
    boolean existsByPassword(String password);
}
