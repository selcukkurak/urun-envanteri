package tr.gov.tuik.urunenvanteri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sayilar {

    private Long anketSayisi;
    private Long idariKayitSayisi;
    private Long kurumSayisi;
    private Long kurulusSayisi;


}
