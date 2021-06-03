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
@Table(name = "istatistiki_urun")
@Audited
public class Urun extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String kodu;
    private String adi;
    private String csa;
    private String amac;
    private String kapsam;
    private String fayda;
    private Long zamanlilik;
    private Boolean silindi;

    @Column(name = "birim_id")
    private String birimId;

    private boolean taslak = true;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans periyot;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans cografiDuzey;

    private boolean uretiliyor;

    @OneToMany(mappedBy = "urun")
    List<HaberBulteni> bultenler = new ArrayList<>();


    @OneToMany(mappedBy = "urun")
    List<Metodoloji> metodolojiler = new ArrayList<>();

    @OneToMany(mappedBy = "urun")
    public List<Paylasim> paylasimlar = new ArrayList<>();

    @OneToMany(mappedBy = "urun")
    public List<MetaveriKonu> metaveriler = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "istatistiki_urun_bagli_urun",
            inverseJoinColumns = @JoinColumn(name = "bagli_urun_id")
    )
    private List<Urun> urunler = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "istatistiki_urun_anket",
            inverseJoinColumns = @JoinColumn(name = "anket_id")
    )
    private List<Anket> anketler = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "istatistiki_urun_idari_kayit",
            inverseJoinColumns = @JoinColumn(name = "idari_kayit_id")
    )
    private List<IdariKayit> idariKayitlar = new ArrayList<>();
}
