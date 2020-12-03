package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;
import tr.gov.tuik.urunenvanteri.entity.Urun;

@Data
@EqualsAndHashCode(callSuper = false)
public class PaylasimDto extends AuditableEntity {
    private Long id;
    private String adi;
    private Long urunId;
    private ReferansDto arac;
    private ReferansDto kurulus;
    private ReferansDto periyot;
}
