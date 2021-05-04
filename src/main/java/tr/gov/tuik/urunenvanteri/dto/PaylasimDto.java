package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class PaylasimDto extends AuditableEntity {
    private Long id;
    private String adi;
    private ReferansDto arac;
    private ReferansDto kurulus;
    private ReferansDto periyot;
    private UrunDto urun;
}
