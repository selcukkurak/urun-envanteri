package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MetaveriIcerikDto {
    private Long id;
    private String aciklama;
    private MetaveriAlanDto alan;
    private MetaveriKonuDto mv;
}
