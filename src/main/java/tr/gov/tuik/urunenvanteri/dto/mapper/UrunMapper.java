package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import tr.gov.tuik.urunenvanteri.dto.UrunBagliUrunlerDto;
import tr.gov.tuik.urunenvanteri.dto.UrunDetayDto;
import tr.gov.tuik.urunenvanteri.dto.UrunDto;
import tr.gov.tuik.urunenvanteri.dto.UrunGirdiCiktiBilgileriDto;
import tr.gov.tuik.urunenvanteri.entity.Anket;
import tr.gov.tuik.urunenvanteri.entity.HaberBulteni;
import tr.gov.tuik.urunenvanteri.entity.IdariKayit;
import tr.gov.tuik.urunenvanteri.entity.Urun;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        uses = {
                ReferansMapper.class,
                HaberBulteniMapper.class,
                PaylasimMapper.class,
                AnketMapper.class,
                IdariKayitMapper.class,
                MetodolojiMapper.class,
                MetaveriKonuMapper.class
        })
public interface UrunMapper extends GenericMapper<Urun, UrunDto> {

    UrunDetayDto toDetayDto(Urun urun);

    Urun toDetayEntity(UrunDetayDto urunDetayDto);

    @Mappings({
            @Mapping(target = "urunler", source = "urunler", qualifiedByName = "urunToId")
    })
    UrunBagliUrunlerDto toBagliUrunDto(Urun urun);

    @Named("urunToId")
    default List<Long> urunToId(List<Urun> urunler) {
        return urunler.stream()
                .map(Urun::getId)
                .collect(Collectors.toList());
    }


    @Mappings({
            @Mapping(target = "idariKayitlar", source = "idariKayitlar"),
            @Mapping(target = "anketler", source = "anketler"),
            @Mapping(target = "urunler", source = "urunler")
    })
    UrunGirdiCiktiBilgileriDto toBilgilerDto(Urun urun);


    @Mappings({
            @Mapping(target = "idariKayitlar", source = "idariKayitlar"),
            @Mapping(target = "anketler", source = "anketler"),
            @Mapping(target = "urunler", source = "urunler"),
            @Mapping(target = "paylasimlar", source = "paylasimlar"),
            @Mapping(target = "metaveriler", source = "metaveriler"),
            @Mapping(target = "bultenler", source = "bultenler"),
    })
    Urun toBilgilerEntity(UrunGirdiCiktiBilgileriDto urunGirdiCiktiBilgileriDto);

}
