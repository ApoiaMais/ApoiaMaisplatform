package com.apoiamais.platform.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.apoiamais.platform.entities.Consultation;
import com.apoiamais.platform.entities.Status;
import com.apoiamais.platform.entities.User;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ConsultationDTO {

    private Long id;
    private LocalDate date;
    @PositiveOrZero(message = "numeros negativos são invalidos")
    private Double price;
    private Status status;
    @Positive(message = "numeros negativos são invalidos")
    private Integer duration;

    private List<UserDTO> users =  new ArrayList<>();
    
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
        for(User entity : consultation.getUsers()) {
            users.add(new UserDTO(entity));
        }

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

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

}
