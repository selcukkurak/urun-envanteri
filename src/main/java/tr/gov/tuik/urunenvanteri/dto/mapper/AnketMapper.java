package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.AnketDto;
import tr.gov.tuik.urunenvanteri.entity.Anket;

@Mapper(componentModel = "spring", uses = ReferansMapper.class)
public interface AnketMapper extends GenericMapper<Anket, AnketDto> {
}
