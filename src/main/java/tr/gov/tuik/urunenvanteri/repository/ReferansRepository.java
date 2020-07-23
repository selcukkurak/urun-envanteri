package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.Referans;
import tr.gov.tuik.urunenvanteri.entity.ReferansTipi;

import java.util.List;

public interface ReferansRepository extends JpaRepository<Referans, Long> {

    List<Referans> findByTipi(ReferansTipi tipi);
}
