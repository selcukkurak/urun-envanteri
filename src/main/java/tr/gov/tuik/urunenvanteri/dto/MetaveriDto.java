package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

@Data
public class MetaveriDto {
    private final Integer id;
    private final String tAd;
    private final String alanAdi;
    private final String aciklama;
    private final String baslik;
    private final Integer alanId;
}
