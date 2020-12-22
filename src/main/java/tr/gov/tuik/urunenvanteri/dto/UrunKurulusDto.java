package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

import java.util.List;

@Data
public class UrunKurulusDto {
    private Long id;
    private List<PaylasimKurulusDto> paylasimlar;
}
