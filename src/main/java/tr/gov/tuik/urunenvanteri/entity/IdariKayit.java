package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Audited
public class IdariKayit extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String kodu;

    private String adi;
    private String kaynakKurumDtvt;
    private String kaynakBirimDtvt;
    private Integer kaynakKurumId;
    private String kaynakKurumAdi;
    private String kaynakBirimAdi;
    private String birimId;
    private Boolean taslak;
    private String transferdenSorumluBirimId;
    private String epostaGruplari;
    private String csa;
    private String sema;
    private String veritabani;
    private String tercihNedeni;
    private String alternatifKaynak;
    private String kisitlar;
    private Boolean silindi;


    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String icerik;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String yasalHukum;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String protokol;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String teslimatSartlari;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "yasal_hukum_dosya_id", referencedColumnName = "id")
    private Dosya yasalHukumDosya;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "protokol_dosya_id", referencedColumnName = "id")
    private Dosya protokolDosya;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans cografiDuzey;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans kullanimAmaci;

    private String kullanimAmaciDigerAciklama;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans veriDuzeyi;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans bicim;

    private String bicimDigerAciklama;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans aktarimBicimi;

    private String aktarimBicimiDigerAciklama;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans transferPeriyot;

    private String transferPeriyotAciklama;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans verininTutulduguYer;

    private String verininTutulduguYerDigerAciklama;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans talepBicimi;

    private String talepBicimiDigerAciklama;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans birimDuzeyi;

    private String birimDuzeyiDigerAciklama;

    @OneToMany(mappedBy = "idariKayit")
    private List<IletisimKisi> iletisimKisileri = new ArrayList<>();

    @OneToMany(mappedBy = "idariKayit")
    private List<TabloBilgisi> tabloBilgileri = new ArrayList<>();


}
