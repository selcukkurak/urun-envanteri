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
    List<UrunHaberBulteni> bultenler = new ArrayList<>();
}
