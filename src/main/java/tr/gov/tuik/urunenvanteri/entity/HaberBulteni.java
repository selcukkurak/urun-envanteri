package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Audited
public class HaberBulteni extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String kodu;

    private String adi;

    private Boolean silindi;

    private Boolean taslak;

    @OneToMany(mappedBy = "bulten")
    public List<HaberBulteniTablo> tablolar = new ArrayList<>();

    @OneToMany(mappedBy = "bulten")
    public List<Kategori> kategoriler = new ArrayList<>();

    @ManyToOne
    private Urun urun;



}
