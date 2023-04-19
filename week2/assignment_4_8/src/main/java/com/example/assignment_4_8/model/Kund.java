package com.example.assignment_4_8.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Kund {


    @Id
    @GeneratedValue
    private long id;
    private String namn;
    private String ssn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Kpi kpi;

    public Kund(String namn, String ssn, Kpi kpi, Kategory kategory) {
        this.namn = namn;
        this.ssn = ssn;
        this.kpi = kpi;
        this.kategory = kategory;
    }

    public Kund(String namn, String ssn, Kpi kpi) {
        this.namn = namn;
        this.ssn = ssn;
        this.kpi = kpi;
    }

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Kategory kategory;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Konto> konto = new ArrayList<>();

    public void addKonto(Konto konto) {
        this.konto.add(konto);
    }

}
