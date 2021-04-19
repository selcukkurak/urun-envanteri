package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tr.gov.tuik.urunenvanteri.dto.MetaveriKonuDto;
import tr.gov.tuik.urunenvanteri.entity.MetaveriKonu;

@Mapper(componentModel = "spring", uses = { MetaveriIcerikMapper.class  })
public interface MetaveriKonuMapper extends GenericMapper<MetaveriKonu, MetaveriKonuDto>{

}
