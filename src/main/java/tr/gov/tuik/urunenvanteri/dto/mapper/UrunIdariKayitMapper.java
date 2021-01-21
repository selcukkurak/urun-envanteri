package tr.gov.tuik.urunenvanteri.dto.mapper;

import tr.gov.tuik.urunenvanteri.dto.IdariKayitUrunDto;
import tr.gov.tuik.urunenvanteri.dto.UrunIdariKayitDto;
import tr.gov.tuik.urunenvanteri.entity.Urun;

import java.util.stream.Collectors;

public class UrunIdariKayitMapper {

    public static UrunIdariKayitDto toDto(Urun urun) {
        return new UrunIdariKayitDto(
                urun.getId(),
                urun.getIdariKayitlar()
                        .stream()
                        .map(idariKayit -> new IdariKayitUrunDto(
                                idariKayit.getId()
                        )).collect(Collectors.toList())
        );
    }
}
