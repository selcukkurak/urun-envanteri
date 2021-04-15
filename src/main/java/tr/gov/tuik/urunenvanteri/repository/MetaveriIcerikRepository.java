package tr.gov.tuik.urunenvanteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.urunenvanteri.entity.MetaveriIcerik;

import java.util.List;

public interface MetaveriIcerikRepository extends JpaRepository<MetaveriIcerik, Long> {

    List<MetaveriIcerik> getAllByMv_Id(Long mv_id);
}
