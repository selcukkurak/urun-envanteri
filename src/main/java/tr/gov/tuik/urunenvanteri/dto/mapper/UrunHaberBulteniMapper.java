package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.UrunHaberBulteniDto;
import tr.gov.tuik.urunenvanteri.entity.UrunHaberBulteni;

@Mapper(componentModel = "spring")
public interface UrunHaberBulteniMapper extends GenericMapper<UrunHaberBulteni, UrunHaberBulteniDto> {
}
