package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.TabloBilgileriDto;
import tr.gov.tuik.urunenvanteri.entity.TabloBilgileri;

@Mapper(componentModel = "spring", uses = KolonBilgileriMapper.class)
public interface TabloBilgileriMapper extends GenericMapper<TabloBilgileri, TabloBilgileriDto> {
}
