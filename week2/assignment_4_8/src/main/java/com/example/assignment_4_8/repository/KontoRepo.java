package com.example.assignment_4_8.repository;

import com.example.assignment_4_8.model.Konto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KontoRepo extends JpaRepository<Konto,Long> {
}
