package tr.gov.tuik.urunenvanteri.dto.mapper;

import org.mapstruct.Mapper;
import tr.gov.tuik.urunenvanteri.dto.Bulten;
import tr.gov.tuik.urunenvanteri.dto.BultenYayin;
import tr.gov.tuik.urunenvanteri.dto.UrunHaberBulteniDto;
import tr.gov.tuik.urunenvanteri.entity.UrunHaberBulteni;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Mapper
public interface BultenMapper extends GenericMapper<UrunHaberBulteni, UrunHaberBulteniDto> {


    static Bulten toDto(Map<String, Object> bulten) {
        return new Bulten(
                (Integer) bulten.get("HB_ID"),
                (String) bulten.get("ADI"),
                new BultenYayin(
                        (Integer) bulten.get("SON_BULTEN_ID"),
                        (String) bulten.get("DONEMI"),
                        (String) bulten.get("URL"),
                        LocalDateTime.parse((String) bulten.get("TARIH"), DateTimeFormatter.ISO_ZONED_DATE_TIME)
                )
        );
    }
}
