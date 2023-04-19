package week2.backend_1_week_2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import week2.backend_1_week_2.Models.Kompis;
import week2.backend_1_week_2.Repos.KompisRepository;

@SpringBootApplication
public class Backend1Week2Application {

    public static void main(String[] args) {
        SpringApplication.run(Backend1Week2Application.class, args);
    }

    @Bean
    public CommandLineRunner saveKompisar(KompisRepository kRepo) {
        return (args) -> {
            kRepo.save(new Kompis("Anna", "Storgatan 1", "0701234567"));
            kRepo.save(new Kompis("Bengt", "Lillgatan 2", "0702345678"));
            kRepo.save(new Kompis("Carl", "Stationsgatan 3", "0703456789"));
            kRepo.save(new Kompis("David Davidsen", "Kungsgatan 4", "0704567890"));
            kRepo.save(new Kompis("Eva Eriksson", "Södra vägen 5", "0705678901"));

        };
    }

}
