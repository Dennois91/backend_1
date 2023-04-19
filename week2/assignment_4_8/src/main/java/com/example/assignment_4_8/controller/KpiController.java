package com.example.assignment_4_8.controller;

import com.example.assignment_4_8.model.Kpi;
import com.example.assignment_4_8.repository.KpiRepo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KpiController {

    private final KpiRepo kpiRepo;

    public KpiController(KpiRepo kpiRepo) {
        this.kpiRepo = kpiRepo;
    }

    @RequestMapping("/kpis")
    public List<Kpi> getAllKpis() {
        return kpiRepo.findAll();
    }

    @RequestMapping("/kpi/add")
    public String addKpis(@RequestParam int kpi) {
        Kpi k = new Kpi(kpi);
        kpiRepo.save(k);
        return "Kpi added " + kpi + " Added";
        //http://localhost:8080/kpi/add?kpi=5
    }

    @RequestMapping("/kpiById/{id}")
    public Kpi getKpiById(@PathVariable Long id) {
        return kpiRepo.findById(id).get();
        //http://localhost:8080/kpiById/1
    }
}
