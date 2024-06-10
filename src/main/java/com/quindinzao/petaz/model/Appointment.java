package com.quindinzao.petaz.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    private LocalDate appointmentTime;

    // Constructors
    public Appointment() {}

    public Appointment(Long id, Pet pet, Service service, LocalDate appointmentTime) {
        this.id = id;
        this.pet = pet;
        this.service = service;
        this.appointmentTime = appointmentTime;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalDate getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDate appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
