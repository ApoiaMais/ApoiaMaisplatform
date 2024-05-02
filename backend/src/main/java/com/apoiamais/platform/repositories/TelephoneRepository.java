package com.apoiamais.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apoiamais.platform.entities.Telephone;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {



    
}