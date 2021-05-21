package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.dto.HaberBulteniIstatikselTabloDto;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteniIstatikselTablo;

import java.util.List;

public interface IstatikselTabloRepository extends JpaRepository<HaberBulteniIstatikselTablo, Long> {

    List<HaberBulteniIstatikselTablo> getAllBy();

    List<HaberBulteniIstatikselTablo> getAllByKategoriId(Long kategoriId);
}
