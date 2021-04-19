package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

import javax.persistence.Id;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class MetaveriKonuDto extends AuditableEntity {
    private Long id;
    private String baslik;
    private List<MetaveriIcerikDto> icerikler;
}
