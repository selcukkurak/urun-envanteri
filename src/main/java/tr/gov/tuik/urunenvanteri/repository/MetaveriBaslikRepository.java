package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.MetaveriBaslik;

import java.util.List;

public interface MetaveriBaslikRepository extends JpaRepository<MetaveriBaslik, Long> {

    List<MetaveriBaslik> getAllBy();
}
