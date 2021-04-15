package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.dto.KategoriDto;
import tr.gov.tuik.urunenvanteri.entity.Kategori;

import java.util.List;

public interface KategoriRepository extends JpaRepository<Kategori, Long> {

    List<Kategori> findAllBy();
}
