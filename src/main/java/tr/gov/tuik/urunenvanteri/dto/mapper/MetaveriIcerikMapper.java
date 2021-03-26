package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.MetaveriIcerikDto;
import tr.gov.tuik.urunenvanteri.entity.MetaveriIcerik;

@Mapper(componentModel = "spring", uses = {MetaveriAlanMapper.class})
public interface MetaveriIcerikMapper extends GenericMapper<MetaveriIcerik, MetaveriIcerikDto>{
}
