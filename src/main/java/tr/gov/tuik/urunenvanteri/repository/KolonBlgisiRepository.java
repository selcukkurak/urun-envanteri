package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.KolonBilgisi;

public interface KolonBlgisiRepository extends JpaRepository<KolonBilgisi, Long> {
}
