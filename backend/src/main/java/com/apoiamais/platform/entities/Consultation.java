package com.apoiamais.platform.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate date;
    private Double price;
    private String status;
    private Integer duration;
    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL)
    private Report report;

    @ManyToOne
	@JoinColumn(name = "patient_id")
    private Patient patient;
    

    @ManyToOne
	@JoinColumn(name = "therapist_id")
    private Therapist therapist;



    public Consultation() {
    }


    public Consultation(Long id, LocalDate date, Double price, String status, Integer duration) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.status = status;
        this.duration = duration;
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


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public Integer getDuration() {
        return duration;
    }

    public Report getReport() {
        return report;
    }


    public void setReport(Report report) {
        this.report = report;
    }


    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    
    public Patient getPatient() {
        return patient;
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public Therapist getTherapist() {
        return therapist;
    }


    public void setTherapist(Therapist therapist) {
        this.therapist = therapist;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Consultation other = (Consultation) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    
}
