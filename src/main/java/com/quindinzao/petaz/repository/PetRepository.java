package com.quindinzao.petaz.repository;

import com.quindinzao.petaz.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
//    List<Pet> findByUserDocument(String document);
    List<Pet> findByUserId(Long userId);
}
