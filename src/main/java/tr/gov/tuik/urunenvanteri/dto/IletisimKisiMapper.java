package tr.gov.tuik.urunenvanteri.dto;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.entity.IletisimKisi;

@Mapper(componentModel = "spring")
public interface IletisimKisiMapper extends GenericMapper<IletisimKisi, IletisimKisiDto> {
}
