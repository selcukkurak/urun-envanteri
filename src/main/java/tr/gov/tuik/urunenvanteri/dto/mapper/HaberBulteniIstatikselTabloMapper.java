package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.HaberBulteniIstatikselTabloDto;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteniIstatikselTablo;

@Mapper(componentModel = "spring", uses = {KategoriMapper.class})
public interface HaberBulteniIstatikselTabloMapper extends GenericMapper<HaberBulteniIstatikselTablo, HaberBulteniIstatikselTabloDto>{
}
