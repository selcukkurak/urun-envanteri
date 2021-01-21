package tr.gov.tuik.urunenvanteri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrunAnketDto {
    private Long id;
    private List<AnketUrunDto> anketIdler;
}
