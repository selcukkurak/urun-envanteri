package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Audited
public class MetaveriKonu extends AuditableEntity {
    @Id
    private Long id;

    @Column(name = "konu_baslik")
    private String baslik;

    @ManyToOne
    private Urun urun;


}
