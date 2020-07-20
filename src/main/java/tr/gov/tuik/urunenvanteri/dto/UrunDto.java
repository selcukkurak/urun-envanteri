package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

@Data
public class UrunDto extends AuditableEntity {
    private Long id;
    private String kodu;
    private String adi;
    private String csa;
    private String birimId;
}
