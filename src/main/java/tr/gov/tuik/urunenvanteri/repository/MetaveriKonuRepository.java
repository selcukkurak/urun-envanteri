package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.MetaveriKonu;

import java.util.List;

public interface MetaveriKonuRepository extends JpaRepository<MetaveriKonu, Long> {

    @EntityGraph(attributePaths = "icerikler")
    List<MetaveriKonu> getAllBy();

    @EntityGraph(attributePaths = "icerikler")
    List<MetaveriKonu> getAllByUrunId(Long id);

}
