package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

import javax.persistence.Id;

@Data
public class DosyaDto extends AuditableEntity {
    @Id
    private Long id;
    private String adi;
    private byte[] data;
    private String tipi;
}

