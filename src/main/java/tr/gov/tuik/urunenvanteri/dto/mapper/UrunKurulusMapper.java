package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.UrunKurulusDto;
import tr.gov.tuik.urunenvanteri.entity.Urun;

@Mapper(componentModel = "spring", uses = PaylasimKurulusMapper.class)
public interface UrunKurulusMapper extends GenericMapper<Urun, UrunKurulusDto>{

}
