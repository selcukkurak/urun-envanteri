package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class BultenDetayDto extends AuditableEntity {

    private String id;
    private List<HaberBulteniTabloDto> tablolar = new ArrayList<>();
    private List<KategoriDto> kategoriler = new ArrayList<>();
}
