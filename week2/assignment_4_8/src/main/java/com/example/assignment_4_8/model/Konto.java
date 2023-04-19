package com.example.assignment_4_8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class Konto {
    @Id
    @GeneratedValue
    private long id;
    private int saldo;
    private int ränta;

    public Konto(int saldo, int ränta) {
        this.saldo = saldo;
        this.ränta = ränta;
    }
}
