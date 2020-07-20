package tr.gov.tuik.urunenvanteri.dto;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.entity.Arac;
import tr.gov.tuik.urunenvanteri.entity.CografiDuzey;

@Mapper(componentModel = "spring")
public interface ReferansMapper {

    AracDto toDto(Arac arac);
    CografiDuzeyDto toDto(CografiDuzey cografiDuzey);
}
