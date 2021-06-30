package tr.gov.tuik.urunenvanteri.dto.mapper;

import tr.gov.tuik.urunenvanteri.dto.AnketUrunDto;
import tr.gov.tuik.urunenvanteri.dto.UrunAnketDto;
import tr.gov.tuik.urunenvanteri.entity.Urun;

import java.util.stream.Collectors;

public class UrunAnketMapper {

    public static UrunAnketDto toDto(Urun urun){
        return new UrunAnketDto(
                urun.getId(),
                urun.getAnketler()
                        .stream()
                        .map(anket -> new AnketUrunDto(
                                anket.getKodu()
                        ))
                        .collect(Collectors.toList())
        );

    }
}
