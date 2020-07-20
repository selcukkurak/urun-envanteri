package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.Arac;
import tr.gov.tuik.urunenvanteri.entity.BirimDuzey;

public interface BirimDuzeyRepository extends JpaRepository<BirimDuzey, Integer> {
}
