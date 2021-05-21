package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.KategoriDto;
import tr.gov.tuik.urunenvanteri.entity.Kategori;
@Mapper(componentModel = "spring", uses = {
        HaberBulteniMapper.class,
        HaberBulteniIstatikselTabloMapper.class
})
public interface KategoriMapper extends GenericMapper<Kategori, KategoriDto> {

}
