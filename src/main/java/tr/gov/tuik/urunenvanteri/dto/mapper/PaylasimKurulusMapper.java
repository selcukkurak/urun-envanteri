package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.PaylasimKurulusDto;
import tr.gov.tuik.urunenvanteri.entity.Paylasim;

@Mapper(componentModel = "spring", uses = ReferansMapper.class)
public interface PaylasimKurulusMapper extends GenericMapper<Paylasim, PaylasimKurulusDto> {
}
