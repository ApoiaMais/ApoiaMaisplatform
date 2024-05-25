package com.apoiamais.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apoiamais.platform.entities.Address;

@Repository
public interface AddresstRepository extends JpaRepository<Address, Long>{

 

}
