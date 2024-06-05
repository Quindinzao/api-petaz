package com.quindinzao.petaz.repository;

import com.quindinzao.petaz.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
