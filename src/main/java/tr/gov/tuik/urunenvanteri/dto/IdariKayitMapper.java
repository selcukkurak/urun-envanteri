package tr.gov.tuik.urunenvanteri.dto;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.entity.IdariKayit;

@Mapper(componentModel = "spring", uses = ReferansMapper.class)
public interface IdariKayitMapper extends GenericMapper<IdariKayit, IdariKayitDto> {
}
