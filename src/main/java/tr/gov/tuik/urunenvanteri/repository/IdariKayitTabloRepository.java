package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.TabloBilgisi;

import java.util.List;

public interface IdariKayitTabloRepository extends JpaRepository<TabloBilgisi, Long> {

    List<TabloBilgisi> getAllByIdariKayitId(String id);
}
