package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.KolonBilgileriDto;
import tr.gov.tuik.urunenvanteri.entity.KolonBilgileri;

@Mapper(componentModel = "spring")
public interface KolonBilgileriMapper extends GenericMapper<KolonBilgileri, KolonBilgileriDto>{
}
