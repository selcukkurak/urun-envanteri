package tr.gov.tuik.urunenvanteri.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class TabloBilgileriDto extends AuditableEntity {
    private Long id;
    @NotNull
    private String adi;
    private String aciklama;
    private String viewAdi;
    private List<KolonBilgileriDto> kolonBilgileri = new ArrayList<>();
    private IdariKayitDto idariKayit;
}
