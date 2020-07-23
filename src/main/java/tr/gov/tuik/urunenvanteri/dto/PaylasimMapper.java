package tr.gov.tuik.urunenvanteri.dto;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.entity.Paylasim;

@Mapper(componentModel = "spring", uses = ReferansMapper.class)
public interface PaylasimMapper extends GenericMapper<Paylasim, PaylasimDto> {
}
