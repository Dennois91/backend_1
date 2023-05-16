package com.example.assignment_4_8.controller;

import com.example.assignment_4_8.model.Kategory;
import com.example.assignment_4_8.repository.KategoryRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class KategoryController {
    private final KategoryRepo kategoryRepo;

    public KategoryController(KategoryRepo kategoryRepo) {
        this.kategoryRepo = kategoryRepo;
    }

    @RequestMapping("/kategories")
    public List<Kategory> getAllKategories() {
        return kategoryRepo.findAll();
    }

    @RequestMapping("/kategory/add")
    public String addKategory(@RequestParam String namn) {
        Kategory kategory = new Kategory(namn);
        kategoryRepo.save(kategory);
        return "Kategory added " + namn + " Added";
        //http://localhost:8080/kategory/add?namn=Kalle
    }

    @RequestMapping("/kategory/delete/{id}")
    public String deleteKategory(@PathVariable Long id) {
        kategoryRepo.deleteById(id);
        return "Kategory deleted " + id + " Deleted";
        //http://localhost:8080/kategory/delete/1
    }
    @RequestMapping("/kategoryById/{id}")
    public Kategory getKategoryById(@PathVariable Long id) {
        return kategoryRepo.findById(id).get();
        //http://localhost:8080/kategoryById/1
    }

    //create a method to add by POST
    @PostMapping("/category/add")
    public String addCategoryPost(@RequestBody Kategory kategory) {
        kategoryRepo.save(kategory);
        return "Kategory added " + kategory.getName() + " Added";

    }
}
