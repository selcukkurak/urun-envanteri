package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Audited
public class Anket extends AuditableEntity {

    @Id
    private String id;
    private String adi;
    private String csa;

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
    private String sema;
    private Integer harzemliDurum;
    private Integer ustDurum;


}
