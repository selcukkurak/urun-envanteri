package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

@Data
public class PaylasimKurulusDto {
    private Long id;
    private Long urunId;
    private ReferansDto kurulus;
}
