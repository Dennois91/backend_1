package week2.backend_1_week_2.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import week2.backend_1_week_2.Models.Kompis;
import week2.backend_1_week_2.Repos.KompisRepository;

import java.util.List;

@RestController
public class KompisController {
    private final KompisRepository kompisRepository;
    private static final Logger log = LoggerFactory.getLogger(KompisController.class);



    public KompisController(KompisRepository kompisRepository) {

        this.kompisRepository = kompisRepository;
    }

    @RequestMapping("/kompis")
    public List<Kompis> getKompis() {
        log.info("Kompis listan hämtades");
        return kompisRepository.findAll();
    }

    @PostMapping("/kompis/add")
    public List<Kompis> addKompis(@RequestBody Kompis kompis) {
        kompisRepository.save(kompis);
        log.info("Kompis med id: " + kompis.getId() + " har lagts till");
        return kompisRepository.findAll();
    }

    @RequestMapping("/kompis/find/{name}")
    public List<Kompis> findKompis(@PathVariable("name") String name) {
        return kompisRepository.findByName(name);
    }

    //Delete kompis by id
    @RequestMapping("/kompis/delete/{id}")
    public List<Kompis> deleteKompis(@PathVariable("id") long id) {
        kompisRepository.deleteById(id);
        System.out.println("Kompis med id: " + id + " har tagits bort");
        log.warn("Kompis med id: " + id + " har tagits bort");
        return kompisRepository.findAll();
    }

    //Update kompis by id
    @RequestMapping("/kompis/update/{id}")
    public List<Kompis> updateKompis(@RequestBody Kompis kompis) {
        kompisRepository.save(kompis);
        return kompisRepository.findAll();
    }

}
