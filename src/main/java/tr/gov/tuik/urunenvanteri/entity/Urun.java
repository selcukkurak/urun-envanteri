package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "istatistiki_urun")
public class Urun extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String kodu;
    private String adi;
    private String csa;

    @Column(name = "birim_id")
    private String birimId;

    private boolean taslak = true;

    @ManyToOne
    private Referans periyot;

    @ManyToOne
    private Referans cografiDuzey;

    private boolean uretiliyor;

    @OneToMany(mappedBy = "urun")
    List<UrunHaberBulteni> bultenler = new ArrayList<>();
}
