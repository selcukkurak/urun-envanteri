package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.HaberBulteniTabloDto;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteniTablo;

@Mapper(componentModel = "spring")
public interface HaberBulteniTabloMapper extends GenericMapper<HaberBulteniTablo, HaberBulteniTabloDto>{
}
