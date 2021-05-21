package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteni;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteniIstatikselTablo;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteniTablo;
import tr.gov.tuik.urunenvanteri.entity.Kategori;

import java.util.List;

public interface HaberBulteniRepository extends JpaRepository<HaberBulteni, String> {

    List<HaberBulteni> getAllBy();

}
