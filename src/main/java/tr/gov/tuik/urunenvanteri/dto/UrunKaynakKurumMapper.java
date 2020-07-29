package tr.gov.tuik.urunenvanteri.dto;

import tr.gov.tuik.urunenvanteri.entity.Urun;

import java.util.stream.Collectors;

public class UrunKaynakKurumMapper {

    public static UrunKaynakKurumDto toDto(Urun urun) {
        return new UrunKaynakKurumDto(
                urun.getId(),
                urun.getIdariKayitlar()
                        .stream()
                .map(idariKayit -> new KaynakKurumDto(
                        idariKayit.getKaynakKurumDtvt(),
                        idariKayit.getKaynakBirimDtvt(),
                        idariKayit.getKaynakKurumId(),
                        idariKayit.getKaynakKurumAdi(),
                        idariKayit.getKaynakBirimAdi()
                )).collect(Collectors.toList())
        );
    }
}
