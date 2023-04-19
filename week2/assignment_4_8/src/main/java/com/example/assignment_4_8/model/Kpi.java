package com.example.assignment_4_8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Kpi {

    @Id
    @GeneratedValue
    private long id;
    private int kreditvärdighet;

    public Kpi(int kreditvärdighet) {
        this.kreditvärdighet = kreditvärdighet;
    }
}
