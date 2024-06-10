package com.quindinzao.petaz.repository;

import com.quindinzao.petaz.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPetUserId(Long petUserId);
    List<Appointment> findByServiceUserId(Long serviceUserId);
}
