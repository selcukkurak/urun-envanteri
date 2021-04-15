package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.dto.HaberBulteniTabloDto;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteniTablo;

import java.util.List;

public interface HaberBulteniTabloRepository extends JpaRepository<HaberBulteniTablo, Long> {

    List<HaberBulteniTablo> getAllBy();

    List<HaberBulteniTablo> getAllByBultenId(String bultenId);
}
