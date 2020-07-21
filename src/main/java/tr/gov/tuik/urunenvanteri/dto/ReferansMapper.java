package tr.gov.tuik.urunenvanteri.dto;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.entity.*;

@Mapper(componentModel = "spring")
public interface ReferansMapper extends GenericMapper<Referans, ReferansDto> {
}
