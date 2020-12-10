package tr.gov.tuik.urunenvanteri.dto.mapper;

import tr.gov.tuik.urunenvanteri.dto.MetaveriDto;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MetaveriMapper {

    public static List<MetaveriDto> toDtoList(List<Map<String, Object>> metaveriler) {
        return metaveriler.stream()
                .map(MetaveriMapper::toDto)
                .collect(Collectors.toList());
    }

    public static MetaveriDto toDto(Map<String, Object> metaveri){
        return new MetaveriDto(
                (Integer) metaveri.get("MV_ID"),
                (String) metaveri.get("TAD"),
                (String) metaveri.get("ALAN_ADI"),
                (String) metaveri.get("ALAN_ACIKLAMA"),
                (String) metaveri.get("KONU_BASLIK"),
                (Integer) metaveri.get("ALAN_ID")
        );
    }
}
