package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.IdariKayit;

import java.util.List;

public interface IdariKayitRepository extends JpaRepository<IdariKayit, String> {

    @EntityGraph(attributePaths = {"cografiDuzey", "kullanimAmaci", "veriDuzeyi", "bicim", "aktarimBicimi", "transferPeriyot", "verininTutulduguYer", "talepBicimi", "birimDuzeyi", "iletisimKisileri"})
    List<IdariKayit> findAllBy();
}