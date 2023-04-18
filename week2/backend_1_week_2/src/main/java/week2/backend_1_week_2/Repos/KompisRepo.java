package week2.backend_1_week_2.Repos;

import lombok.Data;
import week2.backend_1_week_2.Models.Kompis;

import java.util.Arrays;
import java.util.List;

@Data
public class KompisRepo {

    private Kompis kompis1 = new Kompis(0, "Pelle", "Gatan", "0283102");
    private Kompis kompis2 = new Kompis(1, "Elle", "Gatan1", "002");
    private Kompis kompis3 = new Kompis(2, "Lele", "Gatan2", "02102");

    private List<Kompis> kompisList = Arrays.asList(kompis1, kompis2, kompis3);

    public List<Kompis> getKompisList() {
        return kompisList;
    }
}





