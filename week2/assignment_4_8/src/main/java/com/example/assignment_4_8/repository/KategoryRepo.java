package com.example.assignment_4_8.repository;

import com.example.assignment_4_8.model.Kategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoryRepo extends JpaRepository<Kategory,Long> {
}
