package com.quindinzao.petaz.controller;

import com.quindinzao.petaz.model.Pet;
import com.quindinzao.petaz.model.User;
import com.quindinzao.petaz.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetRepository petRepository;

    @PostMapping
    public ResponseEntity<Object> createPet(@RequestBody Pet pet) {
        User user = pet.getUser();
        if (user.getDocument().length() == 11) {
            return ResponseEntity.ok(petRepository.save(pet));
        } else {
            return ResponseEntity.badRequest().body("CNPJ users can't add pets!");
        }
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<Pet>> getPetsByUserId(@PathVariable Long userId) {
        List<Pet> pets = petRepository.findByUserId(userId);
        return ResponseEntity.ok(pets);
    }

//    @GetMapping("/byUser/{document}")
//    public List<Pet> getPetsByUserDocument(@PathVariable String document) {
//        return petRepository.findByUserDocument(document);
//    }
}
