package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

import javax.persistence.Id;
import javax.persistence.Lob;

@Data
public class DosyaDto  {
    @Id
    private Long id;

}

