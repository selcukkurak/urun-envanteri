package tr.gov.tuik.urunenvanteri.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;


@Data
@EqualsAndHashCode(callSuper = false)
public class HaberBulteniDto extends AuditableEntity {
    private Long id;
    @NotNull
    private String adi;
    @NotNull
    private String kodu;
    private Boolean taslak;
    private UrunDto urun;
}
