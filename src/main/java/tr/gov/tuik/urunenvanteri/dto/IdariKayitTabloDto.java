package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import tr.gov.tuik.urunenvanteri.entity.AuditableEntity;

import java.util.ArrayList;
import java.util.List;

@Data
public class IdariKayitTabloDto extends AuditableEntity {

    private String id;
    private List<TabloBilgileriDto> tabloBilgileri = new ArrayList<>();
}
