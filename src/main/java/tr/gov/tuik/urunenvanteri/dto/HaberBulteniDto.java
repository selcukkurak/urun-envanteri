package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;


@Data
@EqualsAndHashCode(callSuper = false)
public class HaberBulteniDto extends AuditableEntity {
    private String id;
    private String adi;
    private String donemi;
    private Boolean taslak;
    private Long sonYayinId;
    private UrunDto urun;
}
