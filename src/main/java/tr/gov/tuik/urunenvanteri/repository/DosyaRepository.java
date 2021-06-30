package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.Dosya;

public interface DosyaRepository extends JpaRepository<Dosya, Long> {

}
