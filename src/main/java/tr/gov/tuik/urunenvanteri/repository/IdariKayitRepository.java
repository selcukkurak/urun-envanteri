package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tr.gov.tuik.urunenvanteri.entity.IdariKayit;

import java.util.List;

public interface IdariKayitRepository extends JpaRepository<IdariKayit, String> {

    @EntityGraph(attributePaths = {"cografiDuzey", "kullanimAmaci", "veriDuzeyi", "bicim", "yasalHukumDosya", "protokolDosya", "aktarimBicimi", "transferPeriyot", "verininTutulduguYer", "talepBicimi", "birimDuzeyi", "iletisimKisileri"})
    List<IdariKayit> findAllBy();

    @EntityGraph(attributePaths = {"tabloBilgileri"})
    List<IdariKayit> findTablolarBy();

    @Query("select count(i.id) as kayit_sayisi from IdariKayit i where i.taslak=false")
    Long kayitSayisi();
}
