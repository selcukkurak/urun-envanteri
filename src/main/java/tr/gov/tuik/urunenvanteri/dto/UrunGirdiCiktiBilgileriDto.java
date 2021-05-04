package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

import javax.persistence.Id;
import java.util.List;

@Data
public class UrunGirdiCiktiBilgileriDto {
    @Id
    private Long id;

    private List<IdariKayitDto> idariKayitlar;

    private List<AnketDto> anketler;

    private List<UrunDto>  urunler;

    private List<PaylasimDto> paylasimlar;

    private List<MetaveriKonuDto> metaveriler;

    private List<HaberBulteniDto> bultenler;


}
