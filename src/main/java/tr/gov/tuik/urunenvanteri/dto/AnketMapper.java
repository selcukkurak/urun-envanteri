package tr.gov.tuik.urunenvanteri.dto;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.entity.Anket;

@Mapper(componentModel = "spring")
public interface AnketMapper extends GenericMapper<Anket, AnketDto> {
}
