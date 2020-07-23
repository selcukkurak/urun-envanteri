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
public class IdariKayit extends AuditableEntity {

    @Id
    private String id;

    private String adi;
    private String kaynakKurumDtvt;
    private String kaynakBirimDtvt;
    private String kaynakKurumAdi;
    private String kaynakBirimAdi;
    private String birimId;
    private String transferdenSorumluBirimId;
    private String epostaGruplari;
    private String csa;
    private String sema;
    private String veritabani;
    private String tercihNedeni;
    private String alternatifKaynak;
    private String kisitlar;

    @Lob
    private String icerik;

    @Lob
    private String yasalHukum;

    @Lob
    private String teslimatSartlari;

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


}
