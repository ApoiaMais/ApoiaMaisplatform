package com.apoiamais.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apoiamais.platform.entities.Patient;
import com.apoiamais.platform.entities.User;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    User save(User user);

}
