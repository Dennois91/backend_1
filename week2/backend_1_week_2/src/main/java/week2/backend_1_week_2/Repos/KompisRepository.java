package week2.backend_1_week_2.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import week2.backend_1_week_2.Models.Kompis;

import java.util.List;

public interface KompisRepository extends JpaRepository<Kompis, Long> {

    public List<Kompis> findByName(String name);
}
