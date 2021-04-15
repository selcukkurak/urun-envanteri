package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.MetaveriKonu;

import java.util.List;

public interface MetaveriKonuRepository extends JpaRepository<MetaveriKonu, Long> {

    List<MetaveriKonu> getAllBy();

    List<MetaveriKonu> getAllByUrunId(Long id);

}
