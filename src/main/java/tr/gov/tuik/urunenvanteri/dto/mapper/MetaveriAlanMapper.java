package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.MetaveriAlanDto;
import tr.gov.tuik.urunenvanteri.entity.MetaveriBaslik;

@Mapper(componentModel = "spring")
public interface MetaveriAlanMapper extends GenericMapper<MetaveriBaslik, MetaveriAlanDto>{
}
