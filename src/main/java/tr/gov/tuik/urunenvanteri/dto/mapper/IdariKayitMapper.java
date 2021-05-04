package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.IdariKayitDto;
import tr.gov.tuik.urunenvanteri.entity.Dosya;
import tr.gov.tuik.urunenvanteri.entity.IdariKayit;

@Mapper(componentModel = "spring", uses = { ReferansMapper.class,
        IletisimKisiMapper.class,
        TabloBilgileriMapper.class
})
public interface IdariKayitMapper extends GenericMapper<IdariKayit, IdariKayitDto> {
}
