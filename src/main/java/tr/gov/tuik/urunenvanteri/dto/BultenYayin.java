package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BultenYayin {
    private final Integer id;
    private final String donemi;
    private final String url;
    private final LocalDateTime tarih;
}
