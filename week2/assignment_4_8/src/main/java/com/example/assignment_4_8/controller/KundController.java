package com.example.assignment_4_8.controller;

import com.example.assignment_4_8.model.Kategory;
import com.example.assignment_4_8.model.Konto;
import com.example.assignment_4_8.model.Kpi;
import com.example.assignment_4_8.model.Kund;
import com.example.assignment_4_8.repository.KategoryRepo;
import com.example.assignment_4_8.repository.KontoRepo;
import com.example.assignment_4_8.repository.KpiRepo;
import com.example.assignment_4_8.repository.KundRepo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KundController {
    private final KundRepo kundRepo;
    private final KpiRepo kpiRepo;
    private final KategoryRepo kategoryRepo;
    private final KontoRepo kontoRepo;

    public KundController(KundRepo kundRepo, KpiRepo kpiRepo, KategoryRepo kategoryRepo, KontoRepo kontoRepo) {

        this.kundRepo = kundRepo;
        this.kpiRepo = kpiRepo;
        this.kategoryRepo = kategoryRepo;
        this.kontoRepo = kontoRepo;
    }

    @RequestMapping("/kunder")
    public List<Kund> getAllKunder() {
        return kundRepo.findAll();
    }

    @RequestMapping("/kund/add")
    public String addKund(@RequestParam String name, @RequestParam String ssn, @RequestParam int kpiCredit) {
        Kpi k = new Kpi(kpiCredit);
        Kund kund = new Kund(name, ssn, k);
        kundRepo.save(kund);
        return "Kund added " + name + " Added";
        //http://localhost:8080/kund/add?name=BellaKalle&ssn=1234567890&kpiCredit=5
    }

    @RequestMapping("/kund/add2")
    //add kund with kategory
    public String addKund2(@RequestParam String name, @RequestParam String ssn,
                           @RequestParam int kpiCredit, @RequestParam Long kategoryId) {
        Kategory kat = kategoryRepo.findById(kategoryId).get();
        Kpi k = new Kpi(kpiCredit);
        Kund kund = new Kund(name, ssn, k, kat);
        kundRepo.save(kund);
        return "Kund added " + name + " Added";
        //http://localhost:8080/kund/add2?name=BellaKalle&ssn=123&kpiCredit=500&kategoryId=1
    }

    @RequestMapping("/kund/addKonto")
    public String addKonto(@RequestParam long kundId, @RequestParam int saldo, @RequestParam int ränta) {
        Kund kund = kundRepo.findById(kundId).get();
        kund.addKonto(new Konto(saldo, ränta));
        kundRepo.save(kund);
        return "Konto added to Added to kund with id " + kundId;
        //http://localhost:8080/kund/addKonto?kundId=1&saldo=1000&ränta=5
    }
    @RequestMapping("/kund/addKonto2")
    public String addKonto2(@RequestParam Long kundId,@RequestParam Long kontoId) {
        Kund kund = kundRepo.findById(kundId).get();
        Konto konto = kontoRepo.findById(kontoId).get();
        kund.addKonto(konto);
        kundRepo.save(kund);
        return "Konto added to Added to kund with id " + kundId;
        //http://localhost:8080/kund/addKonto2?kundId=1&kontoId=1
    }

    @RequestMapping("/kund/changeSaldo")
    public String changeSaldo(@RequestParam Long kontoId, @RequestParam int saldo) {
        Konto konto = kontoRepo.findById(kontoId).get();
        konto.setSaldo(saldo);
        kontoRepo.save(konto);
        return "Saldo changed to " + saldo + " on konto with id " + kontoId;
        //http://localhost:8080/kund/changeSaldo?kontoId=1&saldo=1000
    }

    @RequestMapping("/kund/changeRänta")
    public String changeRänta(@RequestParam Long kontoId, @RequestParam int ränta) {
        Konto konto = kontoRepo.findById(kontoId).get();
        konto.setRänta(ränta);
        kontoRepo.save(konto);
        return "Ränta changed to " + ränta + " on konto with id " + kontoId;
        //http://localhost:8080/kund/changeRänta?kontoId=1&ränta=5
    }

    @RequestMapping("/kund/delete/{id}")
    public String deleteKund(@PathVariable Long id) {
        kundRepo.deleteById(id);
        return "Kund deleted " + id + " Deleted";
        //http://localhost:8080/kund/delete/1
    }


    @RequestMapping("/kundById/{id}")
    public Kund getKundById(@PathVariable Long id) {
        return kundRepo.findById(id).get();
        //http://localhost:8080/kundById/1
    }
}
