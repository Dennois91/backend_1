package com.example.assignment_4_8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kategory {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Kategory(String name) {
        this.name = name;
    }
}
