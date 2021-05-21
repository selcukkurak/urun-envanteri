package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class KategoriDetayDto {

    private Long id;
    private List<HaberBulteniIstatikselTabloDto> istatikselTablolar = new ArrayList<>();

}
