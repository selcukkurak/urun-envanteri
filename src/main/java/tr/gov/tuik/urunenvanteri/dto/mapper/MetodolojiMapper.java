package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.MetodolojiDto;
import tr.gov.tuik.urunenvanteri.entity.Metodoloji;

@Mapper(componentModel = "spring")
public interface MetodolojiMapper extends GenericMapper<Metodoloji, MetodolojiDto>{
}
