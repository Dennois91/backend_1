package com.example.assignment_4_8;

import com.example.assignment_4_8.model.Kategory;
import com.example.assignment_4_8.model.Kpi;
import com.example.assignment_4_8.model.Kund;
import com.example.assignment_4_8.repository.KategoryRepo;
import com.example.assignment_4_8.repository.KundRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Assignment48Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment48Application.class, args);
    }

//    @Bean
//    public CommandLineRunner saveKunder(KundRepo kundRepo, KategoryRepo kategoryRepo) {
//        return (args) -> {
//            Kpi k1 = new Kpi(20);
//            Kpi k2 = new Kpi(30);
//            Kpi k3 = new Kpi(40);
//
//            Kategory kategory1 = new Kategory("Guld");
//            Kategory kategory2 = new Kategory("Silver");
//            Kategory kategory3 = new Kategory("Bronze");
//
//            kategoryRepo.save(kategory1);
//            kategoryRepo.save(kategory2);
//            kategoryRepo.save(kategory3);
//
//            Kund kund1 = new Kund("Anna", "1234567890", k1, kategory1);
//            Kund kund2 = new Kund("Bengt", "0987654321", k2, kategory2);
//            Kund kund3 = new Kund("Carl", "1234567890", k3, kategory3);
//
//            kundRepo.save(kund1);
//            kundRepo.save(kund2);
//            kundRepo.save(kund3);
//        };
//    }




}
