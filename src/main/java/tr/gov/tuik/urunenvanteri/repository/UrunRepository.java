package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import tr.gov.tuik.urunenvanteri.dto.UrunDto;
import tr.gov.tuik.urunenvanteri.entity.Urun;

import java.util.List;
import java.util.stream.Stream;

public interface UrunRepository extends JpaRepository<Urun, Long>, RevisionRepository<Urun, Long, Integer> {

    List<Urun> findByTaslakFalse();
}
