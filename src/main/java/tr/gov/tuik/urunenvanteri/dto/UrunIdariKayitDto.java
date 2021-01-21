package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

import java.util.List;

@Data
public class UrunIdariKayitDto {
    private final Long id;
    private final List<IdariKayitUrunDto> idariKayitIdler;
}
