package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteniTablo;

import java.util.List;

public interface HaberBulteniTabloRepository extends JpaRepository<HaberBulteniTablo, Long> {

    List<HaberBulteniTablo> getAllByBultenId(Long bulten_id);
}
