package com.apoiamais.platform.dtos;

import java.time.LocalDate;

import com.apoiamais.platform.entities.Consultation;
import com.apoiamais.platform.entities.Status;

public class ConsultationDTO {

    private Long id;
    private LocalDate date;
    private Double price;
    private Status status;
    private Integer duration;
    
    public ConsultationDTO() {
    }

    public ConsultationDTO(Long id, LocalDate date, Double price, Status status, Integer duration) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.status = status;
        this.duration = duration;
    }

    public ConsultationDTO(Consultation consultation) {
        this.id = consultation.getId();
        this.date = consultation.getDate();
        this.price = consultation.getPrice();
        this.status = consultation.getStatus();
        this.duration = consultation.getDuration();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    

}
