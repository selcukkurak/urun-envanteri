package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.Paylasim;

public interface PaylasimRepository extends JpaRepository<Paylasim, Long> {
}
