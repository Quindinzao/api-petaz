package com.quindinzao.petaz.controller;

import com.quindinzao.petaz.model.Service;
import com.quindinzao.petaz.model.User;
import com.quindinzao.petaz.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create(@RequestBody Service service) {
        User user = service.getUser();
        if (user.getDocument().length() == 14) {
            return ResponseEntity.ok(serviceRepository.save(service));
        } else {
            return ResponseEntity.badRequest().body("CPF users can't add services!");
        }
    }

    @GetMapping("/byUser/{document}")
    public List<Service> getServicesByUserDocument(@PathVariable String document) {
        return serviceRepository.findByUserDocument(document);
    }
}
