package com.example.backend_1.assignment_2_8;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Friend {
    private int id = 0;
    private List<String> names;
    private LocalDate birthday;
    private String adress;
    private List<String> telefonnummer;

}

/*
• För er som blir klara snabbt, bygg ut Kompis-modellen till att även innehålla nick, kunna ha
flera telefonnummer, ha en födelsedag och kunna ha flera adresser

• Gör POJO-klassen Kompis.java
        • En kompis har:
        • Id
        • Namn
        • Adress
        • Telefonnummer
        • Gör en metod som returnerar ett objekt av typen Kompis med JSON (objektet kan vara
        hårdkodat nu, vi ska jobba vidare med det sen, detta är bara för att se att det funkar att
        returnera ett objekt)
        • http://localhost:8080/kompis
        • Kolla att kompisen visas fint i din browser
        • Använd gärna Lombok
        */