package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class KategoriDto extends AuditableEntity {
    private Long id;
    private String adi;
    private HaberBulteniDto bulten;
    private List<HaberBulteniIstatikselTabloDto> istatikselTablolar;
}
