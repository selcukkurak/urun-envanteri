package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

@Data
public class KaynakKurumDto {
    private final String kurumDtvt;
    private final String birimDtvt;
    private final Integer kurumId;
    private final String kurumAdi;
    private final String birimAdi;
}
