package week2.backend_1_week_2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControle {

    @RequestMapping("/Hello")
    public String HelloWorld(){
        return "HelloWorld";
    }

}

/*
Uppgift 1c – Skapa en Entitet
• I IntelliJ, skapa 3 kod-mappar så att allt är snyggt och prydligt
• Models
• Controllers
• Repos
•
• Skapa sedan en POJO Kompis.java
• Konpis ska minst ha:
• Id
• Namn
• Adress
• Mobilnr
• Låt Kompis bli en Entity och sätt ut alla annoteringar som behövs.
• Skapa getters och setters, eller använd Lombok.
 */
