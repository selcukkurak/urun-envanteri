package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.Anket;

import java.util.List;

public interface AnketRepository extends JpaRepository<Anket, String> {

    @EntityGraph(attributePaths = {"periyot", "cografiDuzey", "birimDuzey"})
    List<Anket> findAllBy();
}
