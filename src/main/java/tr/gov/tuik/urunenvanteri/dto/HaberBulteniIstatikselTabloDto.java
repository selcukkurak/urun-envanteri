package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class HaberBulteniIstatikselTabloDto extends AuditableEntity {
    private Long id;
    private String tabloAdi;
    private String veritabaniTabloAdi;
    private String aciklama;
    private KategoriDto kategori;
}
