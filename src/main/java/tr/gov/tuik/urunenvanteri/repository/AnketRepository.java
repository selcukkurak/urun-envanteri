package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.Anket;

public interface AnketRepository extends JpaRepository<Anket, String> {
}
