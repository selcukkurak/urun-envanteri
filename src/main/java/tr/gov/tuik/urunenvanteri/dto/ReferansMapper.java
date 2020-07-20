package tr.gov.tuik.urunenvanteri.dto;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.entity.*;

@Mapper(componentModel = "spring")
public interface ReferansMapper {

    ReferansDto toDto(Arac arac);
    ReferansDto toDto(CografiDuzey cografiDuzey);
    ReferansDto toDto(BirimDuzey birimDuzey);
    ReferansDto toDto(Periyot periyot);
    ReferansDto toDto(Kurulus kurulus);
}
