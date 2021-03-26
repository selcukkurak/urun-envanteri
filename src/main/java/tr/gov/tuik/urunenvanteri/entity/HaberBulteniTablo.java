package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Audited
public class HaberBulteniTablo extends AuditableEntity {

    @Id
    private Long id;

    private String tabloAdi;

    private String veritabaniTabloAdi;

    private String aciklama;

    @ManyToOne
    private HaberBulteni bulten;

}