package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.IdariKayitTabloDto;
import tr.gov.tuik.urunenvanteri.entity.IdariKayit;

@Mapper(componentModel = "spring", uses = { TabloBilgileriMapper.class })
public interface IdariKayitTabloMapper extends GenericMapper<IdariKayit, IdariKayitTabloDto>{
}
