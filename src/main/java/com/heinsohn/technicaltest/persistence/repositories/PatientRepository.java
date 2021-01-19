package com.heinsohn.technicaltest.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.heinsohn.technicaltest.persistence.model.Patient;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
