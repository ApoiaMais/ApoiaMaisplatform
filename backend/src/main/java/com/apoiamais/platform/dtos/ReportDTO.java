package com.apoiamais.platform.dtos;

import java.time.Instant;

import com.apoiamais.platform.entities.Report;

public class ReportDTO {

    private Long id;
    private Instant date;
    private String description;
    private Long consultationId;
    
    public ReportDTO() {
    }

    public ReportDTO(Long id, Instant date, String description, Long consultationId) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.consultationId = consultationId;
    }

    public ReportDTO(Report report) {
        this.id = report.getId();
        this.date = report.getDate();
        this.description = report.getDescription();
        this.consultationId = report.getConsultation().getId();
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

    public Long getConsultationId() {
        return consultationId;
    }

    public void setConsultation(Long consultationId) {
        this.consultationId = consultationId;
    }

    
}
