package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "istatistiki_urun_haber_bulteni")
@Audited
public class UrunHaberBulteni extends AuditableEntity {

    @Id
    private Long id;
    private Integer bultenId;

    @ManyToOne
    private Urun urun;
}
