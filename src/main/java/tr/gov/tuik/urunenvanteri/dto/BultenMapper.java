package tr.gov.tuik.urunenvanteri.dto;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@Slf4j
public class BultenMapper {

    public static Bulten toDto(Map<String, Object> bulten) {
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
