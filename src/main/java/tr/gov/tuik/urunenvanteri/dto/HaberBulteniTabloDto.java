package tr.gov.tuik.urunenvanteri.dto;

import lombok.Data;

import javax.persistence.Id;

@Data
public class HaberBulteniTabloDto {
    @Id
    private Long id;
    private String tabloAdi;
    private String veritabaniTabloAdi;
    private String aciklama;
    private HaberBulteniDto bulten;
}
