package com.quindinzao.petaz.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_cpf_id")
    private User userCpf;

    @ManyToOne
    @JoinColumn(name = "user_cnpj_id")
    private User userCnpj;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    private LocalDateTime appointmentTime;

    // Constructors
    public Appointment() {}

    public Appointment(Long id, User userCpf, User userCnpj, Pet pet, Service service, LocalDateTime appointmentTime) {
        this.id = id;
        this.userCpf = userCpf;
        this.userCnpj = userCnpj;
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

    public User getUserCpf() {
        return userCpf;
    }

    public void setUserCpf(User userCpf) {
        this.userCpf = userCpf;
    }

    public User getUserCnpj() {
        return userCnpj;
    }

    public void setUserCnpj(User userCnpj) {
        this.userCnpj = userCnpj;
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

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
