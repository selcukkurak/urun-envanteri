package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.Paylasim;
import java.util.List;

public interface PaylasimRepository extends JpaRepository<Paylasim, Long> {

    @EntityGraph(attributePaths = "kurulus")
    List<Paylasim> findAllBy();
}
