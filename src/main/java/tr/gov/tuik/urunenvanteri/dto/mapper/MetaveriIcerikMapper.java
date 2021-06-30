package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tr.gov.tuik.urunenvanteri.dto.MetaveriIcerikDto;
import tr.gov.tuik.urunenvanteri.entity.MetaveriIcerik;

@Mapper(componentModel = "spring")
public interface MetaveriIcerikMapper{


    @Mappings({
            @Mapping(target = "mv.id", source = "mvId")
    })
    MetaveriIcerik toResourceEntity(MetaveriIcerikDto dto);

    MetaveriIcerikDto toDto(MetaveriIcerik icerik);
}
