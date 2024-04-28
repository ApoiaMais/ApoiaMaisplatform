package com.apoiamais.platform.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataTimeQuery;
    private Integer durationAppointment;
    private String descpritionAppointment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "therapist_id")
    private Therapist therapist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataTimeQuery() {
        return dataTimeQuery;
    }

    public void setDataTimeQuery(LocalDateTime dataTimeQuery) {
        this.dataTimeQuery = dataTimeQuery;
    }

    public Integer getDurationAppointment() {
        return durationAppointment;
    }

    public void setDurationAppointment(Integer durationAppointment) {
        this.durationAppointment = durationAppointment;
    }

    public String getDescpritionAppointment() {
        return descpritionAppointment;
    }

    public void setDescpritionAppointment(String descpritionAppointment) {
        this.descpritionAppointment = descpritionAppointment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Therapist getTherapist() {
        return therapist;
    }

    public void setTherapist(Therapist therapist) {
        this.therapist = therapist;
    }

}
