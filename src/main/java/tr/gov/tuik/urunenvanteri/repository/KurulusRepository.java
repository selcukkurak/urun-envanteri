package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.Kurulus;

public interface KurulusRepository extends JpaRepository<Kurulus, Integer> {
}
