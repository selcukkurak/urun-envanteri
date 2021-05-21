package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.KolonBilgileriDto;
import tr.gov.tuik.urunenvanteri.entity.KolonBilgisi;

@Mapper(componentModel = "spring", uses = {TabloBilgileriMapper.class})
public interface KolonBilgileriMapper extends GenericMapper<KolonBilgisi, KolonBilgileriDto>{
}
