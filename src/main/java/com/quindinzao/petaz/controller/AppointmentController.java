package com.quindinzao.petaz.controller;

import com.quindinzao.petaz.model.Appointment;
import com.quindinzao.petaz.model.Pet;
import com.quindinzao.petaz.model.User;
import com.quindinzao.petaz.repository.AppointmentRepository;
import com.quindinzao.petaz.repository.PetRepository;
import com.quindinzao.petaz.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

//    @Autowired
//    private PetRepository petRepository;
//
//    @Autowired
//    private ServiceRepository serviceRepository;

    @PostMapping
    public ResponseEntity<Object> createAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    @GetMapping("/byUserCPF/{id}")
    public ResponseEntity<List<Appointment>> getAppointmentByCPFId(@PathVariable Long id) {
        List<Appointment> appointments = appointmentRepository.findByPetUserId(id);
        if (appointments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/byUserCNPJ/{id}")
    public ResponseEntity<List<Appointment>> getAppointmentByCNPJId(@PathVariable Long id) {
        List<Appointment> appointments = appointmentRepository.findByServiceUserId(id);
        if (appointments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointments);
    }
}
