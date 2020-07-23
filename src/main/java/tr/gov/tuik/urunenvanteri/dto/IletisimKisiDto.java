package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class IletisimKisiDto extends AuditableEntity {
    private Long id;
    private Long tcKimlikNo;
    private String adSoyad;
    private String unvan;
    private String birimId;
    private String disBirimId;
    private String disBirimAdi;
    private String telefon;
    private String eposta;
    private boolean kurumDisi;
}
