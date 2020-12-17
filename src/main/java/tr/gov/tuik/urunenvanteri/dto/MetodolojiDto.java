package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

@Data
public class MetodolojiDto {

    private Long id;
    private String adi;
    private String standartiBelirleyenKurum;
    private String dokumanAdi;
    private String url;
    private String gecerlilikTarihi;
}
