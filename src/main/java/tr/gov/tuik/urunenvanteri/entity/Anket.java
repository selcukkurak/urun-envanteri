package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Audited
public class Anket extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String kodu;

    private String adi;
    private String csa;
    private boolean silindi;

    @Column(name = "birim_id")
    private String birimId;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans periyot;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans cografiDuzey;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Referans birimDuzey;

    private Integer orneklemSayisi;
    private boolean taslak;
    private String sema;
    private Integer harzemliDurum;
    private Integer ustDurum;

    @Column(name = "anketor_sayisi_merkez")
    private Integer anketorSayisiMerkez;

    @Column(name = "kontrolor_sayisi_merkez")
    private Integer kontrolorSayisiMerkez;

    @Column(name = "anketor_sayisi_bolge")
    private Integer anketorSayisiBolge;

    @Column(name = "kontrolor_sayisi_bolge")
    private Integer kontrolorSayisiBolge;

}
