package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
public class TabloBilgileriDto extends AuditableEntity {
    @Id
    private Long id;
    private String adi;
    private String aciklama;
    private String viewAdi;
    private List<KolonBilgileriDto> kolonBilgileri = new ArrayList<>();
}
