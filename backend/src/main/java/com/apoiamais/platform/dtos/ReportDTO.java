package com.apoiamais.platform.dtos;

import com.apoiamais.platform.entities.Consultation;
import com.apoiamais.platform.entities.Report;

import java.time.Instant;

public class ReportDTO {

    private Long id;
    private Instant date;
    private String description;
    private Consultation consultation;
    
    public ReportDTO() {
    }

    public ReportDTO(Long id, Instant date, String description, Consultation consultation) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.consultation = consultation;
    }

    public ReportDTO(Report report) {
        this.id = report.getId();
        this.date = report.getDate();
        this.description = report.getDescription();
        this.consultation = report.getConsultation();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    
}
