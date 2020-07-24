package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.UrunDto;
import tr.gov.tuik.urunenvanteri.entity.Urun;

@Mapper(componentModel = "spring", uses = ReferansMapper.class)
public interface UrunMapper extends GenericMapper<Urun, UrunDto> {
}
