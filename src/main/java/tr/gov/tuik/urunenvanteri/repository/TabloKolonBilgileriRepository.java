package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.dto.KolonBilgileriDto;
import tr.gov.tuik.urunenvanteri.entity.KolonBilgisi;

import java.util.List;

public interface TabloKolonBilgileriRepository extends JpaRepository<KolonBilgisi, Long> {

    List<KolonBilgileriDto> getAllByTabloBilgisiId(Long id);
}
