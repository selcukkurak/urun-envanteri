package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;
import tr.gov.tuik.urunenvanteri.entity.ReferansTipi;

import java.util.List;
import java.util.Map;

@Data
public class ReferanslarPayload {
    private final ReferansTipi[] referansTipleri;
    private final Map<ReferansTipi, List<ReferansDto>> referanslar;
}
