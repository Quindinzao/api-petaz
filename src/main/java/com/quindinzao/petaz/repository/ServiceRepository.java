package com.quindinzao.petaz.repository;

import com.quindinzao.petaz.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByUserDocument(String document);
}
