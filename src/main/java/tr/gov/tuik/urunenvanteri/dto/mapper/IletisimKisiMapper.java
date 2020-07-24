package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.IletisimKisiDto;
import tr.gov.tuik.urunenvanteri.entity.IletisimKisi;

@Mapper(componentModel = "spring")
public interface IletisimKisiMapper extends GenericMapper<IletisimKisi, IletisimKisiDto> {
}
