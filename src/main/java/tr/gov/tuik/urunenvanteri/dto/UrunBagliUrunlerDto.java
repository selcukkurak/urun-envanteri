package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UrunBagliUrunlerDto {
    private Long id;
    private String adi;
    private List<Long> urunler = new ArrayList<>();
}
