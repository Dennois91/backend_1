package week2.backend_1_week_2.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class Kompis {

    @Id
    @GeneratedValue
    private long id;
    String name;
    String adress;
    String mobilnummer;

    public Kompis(String name, String adress, String mobilnummer) {
        this.name = name;
        this.adress = adress;
        this.mobilnummer = mobilnummer;
    }


}

/*
• Skapa sedan en POJO Kompis.java
• Konpis ska minst ha:
• Id
• Namn
• Adress
• Mobilnr
• Låt Kompis bli en Entity och sätt ut alla annoteringar som behövs.
• Skapa getters och setters, eller använd Lombok.
 */