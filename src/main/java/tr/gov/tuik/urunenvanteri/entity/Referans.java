package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import tr.gov.tuik.urunenvanteri.entity.ReferansTipi;

import javax.persistence.*;

@Data
@Entity
public class Referans {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer kodu;
    private String adi;

    @Enumerated(EnumType.STRING)
    private ReferansTipi tipi;
}
