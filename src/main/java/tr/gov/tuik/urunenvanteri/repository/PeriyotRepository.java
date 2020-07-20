package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.BirimDuzey;
import tr.gov.tuik.urunenvanteri.entity.Periyot;

public interface PeriyotRepository extends JpaRepository<Periyot, Integer> {
}
