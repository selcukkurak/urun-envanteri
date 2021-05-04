package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.DosyaDto;
import tr.gov.tuik.urunenvanteri.entity.Dosya;

@Mapper(componentModel = "spring")
public interface DosyaMapper extends GenericMapper<Dosya, DosyaDto>{
}
