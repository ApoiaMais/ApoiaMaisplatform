package com.apoiamais.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apoiamais.platform.entities.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
