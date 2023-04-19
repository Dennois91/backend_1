package com.example.assignment_4_8.controller;

import com.example.assignment_4_8.model.Konto;
import com.example.assignment_4_8.repository.KontoRepo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KontoController {
    private final KontoRepo kontoRepo;

    public KontoController(KontoRepo kontoRepo) {
        this.kontoRepo = kontoRepo;
    }

    @RequestMapping("/konton")
    public List<Konto> getAllKonton() {
        return kontoRepo.findAll();
    }
    @RequestMapping("/konto/delete/{id}")
    public String deleteKonto(@PathVariable Long id) {
        kontoRepo.deleteById(id);
        return "Konto deleted " + id + " Deleted";
        //http://localhost:8080/konto/delete/1
    }
}
