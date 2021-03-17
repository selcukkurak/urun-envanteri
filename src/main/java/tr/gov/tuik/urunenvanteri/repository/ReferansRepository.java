package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tr.gov.tuik.urunenvanteri.entity.Referans;
import tr.gov.tuik.urunenvanteri.entity.ReferansTipi;

import java.util.List;

public interface ReferansRepository extends JpaRepository<Referans, Long> {

    List<Referans> findByTipi(ReferansTipi tipi);

    @Query("select count(r.id) as kurum_sayisi from Referans r where r.tipi='KAYNAK_KURUM'")
    Long kurumSayisi();

    @Query("select count(r.id) as kurulus_sayisi from Referans r where r.tipi='KURULUS'")
    Long kurulusSayisi();
}
