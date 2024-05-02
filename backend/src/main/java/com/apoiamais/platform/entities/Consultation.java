package com.apoiamais.platform.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate date;
    private Double price;
    private Status status;
    private Integer duration;
    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL)
    private Report report;
    
    @ManyToMany(mappedBy = "consultations")
    private Set<User> users = new HashSet<>();

    

    public Consultation() {
    }


    public Consultation(Long id, LocalDate date, Double price, Status status, Integer duration) {
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


    public Status getStatus() {
        return status;
    }


    public void setStatus(Status status) {
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
