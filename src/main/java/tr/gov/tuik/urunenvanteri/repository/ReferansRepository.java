package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.Referans;
import tr.gov.tuik.urunenvanteri.entity.ReferansTipi;

import java.util.List;
import java.util.Optional;

public interface ReferansRepository extends JpaRepository<Referans, Long> {

    Optional<Referans> findByKoduAndTipi(Integer kodu, ReferansTipi tipi);

    List<Referans> findByTipi(ReferansTipi tipi);
}
