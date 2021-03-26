package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.HaberBulteniDto;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteni;

@Mapper(componentModel = "spring", uses = { HaberBulteniTabloMapper.class, HaberBulteniIstatikselTabloMapper.class })
public interface HaberBulteniMapper extends GenericMapper<HaberBulteni, HaberBulteniDto>{
}