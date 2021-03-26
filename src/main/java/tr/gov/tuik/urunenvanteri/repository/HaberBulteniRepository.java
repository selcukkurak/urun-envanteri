package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteni;

import java.util.List;

public interface HaberBulteniRepository extends JpaRepository<HaberBulteni, String> {

    List<HaberBulteni> getAllBy();
}
