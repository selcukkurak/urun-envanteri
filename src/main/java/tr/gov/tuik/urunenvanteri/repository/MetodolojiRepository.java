package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.Metodoloji;

import java.util.List;

public interface MetodolojiRepository extends JpaRepository<Metodoloji, Long> {

    List<Metodoloji> getMetodolojiByUrunId(Long urunId);
}
