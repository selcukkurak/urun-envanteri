package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

@Data
public class UrunRaporDto {
    private final Long id;
    private final int urun;
    private final int anket;
    private final int idariKayit;
    private final int bultenler;
}
