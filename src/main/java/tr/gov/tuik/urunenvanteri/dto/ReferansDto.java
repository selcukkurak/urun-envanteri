package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import tr.gov.tuik.urunenvanteri.entity.ReferansTipi;

@Data
public class ReferansDto {
    private Long id;
    private Integer kodu;
    private String adi;
    private ReferansTipi tipi;
}
