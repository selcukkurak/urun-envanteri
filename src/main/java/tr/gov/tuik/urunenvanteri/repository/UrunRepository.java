package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import tr.gov.tuik.urunenvanteri.dto.UrunIdariKayitDto;
import tr.gov.tuik.urunenvanteri.dto.UrunRaporDto;
import tr.gov.tuik.urunenvanteri.entity.Urun;

import java.util.List;
import java.util.Optional;

public interface UrunRepository extends JpaRepository<Urun, Long>, RevisionRepository<Urun, Long, Integer> {

    @EntityGraph(attributePaths = {"bultenler", "periyot", "cografiDuzey"})
    List<Urun> findAllBy();

    @EntityGraph(attributePaths = {"bultenler", "periyot", "cografiDuzey"})
    List<Urun> findByTaslakFalse();

    @EntityGraph(attributePaths = {"bultenler", "periyot", "cografiDuzey"})
    Optional<Urun> findWithDetayById(Long id);

    @EntityGraph(attributePaths = {"urunler"})
    List<Urun> findWithUrunlerByTaslakFalse();

    @Query("select new tr.gov.tuik.urunenvanteri.dto.UrunRaporDto(u.id, size(u.urunler), size(u.anketler), size(u.idariKayitlar), size(u.bultenler) ) from Urun u")
    List<UrunRaporDto> urunGirdiSayilari();

    @EntityGraph(attributePaths = {"idariKayitlar"})
    List<Urun> findAllWithIdariKayitIdBy();

    @EntityGraph(attributePaths = {"anketler"})
    List<Urun> findAllWithAnketIdBy();

    @EntityGraph(attributePaths = {"idariKayitlar"})
    List<Urun> findAllWithIdariKayitBy();

    @EntityGraph(attributePaths = {"paylasimlar" , "paylasimlar.kurulus"})
    List<Urun> findAllWithPaylasimlarBy();
}
