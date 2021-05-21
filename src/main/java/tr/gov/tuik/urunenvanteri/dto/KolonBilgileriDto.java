package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

import javax.persistence.Id;

@Data
public class KolonBilgileriDto {
    @Id
    private Long id;

    private String adi;

    private String aciklama;

    private Long keyKontrol;

    private String iliskiliTabloKolonAdi;

    private TabloBilgileriDto tabloBilgisi;
}
