package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class MetaveriKonuDto extends AuditableEntity {
    private Long id;
    private String baslik;
    private MetaveriIcerikDto icerik;
}
