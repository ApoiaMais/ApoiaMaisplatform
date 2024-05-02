package com.apoiamais.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apoiamais.platform.entities.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{

    

}