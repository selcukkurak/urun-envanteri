package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tr.gov.tuik.urunenvanteri.dto.HaberBulteniDto;
import tr.gov.tuik.urunenvanteri.dto.HaberBulteniTabloDto;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteniTablo;
@Mapper(componentModel = "spring")
public interface HaberBulteniTabloMapper {


    @Mappings({
            @Mapping(target = "bulten.id", source = "bultenId")
    })
    HaberBulteniTablo toResourceDto(HaberBulteniTabloDto dto);

    HaberBulteniTabloDto toDto(HaberBulteniTablo entity);
}
