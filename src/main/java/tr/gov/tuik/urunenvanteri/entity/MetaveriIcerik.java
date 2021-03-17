package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Audited
public class MetaveriIcerik extends AuditableEntity{
    @Id
    private Long id;
    @ManyToOne
    private MetaveriKonu mv;

    @Column(columnDefinition = "text")
    private String aciklama;

    @ManyToOne
    private MetaveriBaslik alan;

}
