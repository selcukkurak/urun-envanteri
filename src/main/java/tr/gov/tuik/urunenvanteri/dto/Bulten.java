package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

@Data
public class Bulten {
    private final Integer id;
    private final String adi;
    private final BultenYayin sonYayin;
}
