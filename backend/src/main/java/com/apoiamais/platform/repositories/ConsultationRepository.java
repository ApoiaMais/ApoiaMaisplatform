package com.apoiamais.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apoiamais.platform.entities.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{

    

}
