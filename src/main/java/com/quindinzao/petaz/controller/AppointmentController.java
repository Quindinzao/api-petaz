package com.quindinzao.petaz.controller;

import com.quindinzao.petaz.dto.AppointmentRequest;
import com.quindinzao.petaz.model.Appointment;
import com.quindinzao.petaz.model.Pet;
import com.quindinzao.petaz.model.Service;
import com.quindinzao.petaz.model.User;
import com.quindinzao.petaz.repository.AppointmentRepository;
import com.quindinzao.petaz.repository.PetRepository;
import com.quindinzao.petaz.repository.ServiceRepository;
import com.quindinzao.petaz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping
    public ResponseEntity<Object> createAppointment(@RequestBody AppointmentRequest request) {
        Optional<User> userCpfOptional = userRepository.findById(request.getUserCpfId());
        if (userCpfOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("User CPF not found");
        }

        Optional<User> userCnpjOptional = userRepository.findById(request.getUserCnpjId());
        if (userCnpjOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("User CNPJ not found");
        }

        Optional<Pet> petOptional = petRepository.findById(request.getPetId());
        if (petOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Pet not found");
        }

        Optional<Service> serviceOptional = serviceRepository.findById(request.getServiceId());
        if (serviceOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Service not found");
        }

        Appointment appointment = new Appointment();
        appointment.setUserCpf(userCpfOptional.get());
        appointment.setUserCnpj(userCnpjOptional.get());
        appointment.setPet(petOptional.get());
        appointment.setService(serviceOptional.get());
        appointment.setAppointmentTime(request.getAppointmentTime());
        return ResponseEntity.ok(appointment);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getAppointmentById(@PathVariable Long id) {
//
//    }
}
