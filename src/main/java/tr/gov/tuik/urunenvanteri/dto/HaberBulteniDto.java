package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class HaberBulteniDto extends AuditableEntity {
    private String id;
    private String adi;
    private String donemi;
    private Long sonYayinId;
    private Boolean taslak;
    private List<HaberBulteniTabloDto> tablolar = new ArrayList<>();
    private UrunDto urun;
}
