package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tr.gov.tuik.urunenvanteri.dto.IdariKayitDto;
import tr.gov.tuik.urunenvanteri.entity.Dosya;
import tr.gov.tuik.urunenvanteri.entity.IdariKayit;

@Mapper(componentModel = "spring", uses = { ReferansMapper.class,
        IletisimKisiMapper.class,
        TabloBilgileriMapper.class
})
public interface IdariKayitMapper {

    @Mappings({
            @Mapping(target = "yasalHukumDosyaId", source = "yasalHukumDosya.id"),
            @Mapping(target = "protokolDosyaId", source = "protokolDosya.id")
    })
    IdariKayitDto toDto(IdariKayit entity);

    @Mappings({
            @Mapping(target = "yasalHukumDosya.id", source = "yasalHukumDosyaId"),
            @Mapping(target = "protokolDosya.id", source = "protokolDosyaId")
    })
    IdariKayit toEntity(IdariKayitDto dto);
}
