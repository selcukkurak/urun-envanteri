package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Audited
public class KolonBilgisi extends AuditableEntity{

    @Id
    private Long id;

    private String adi;

    private String aciklama;

    private Long keyKontrol;

    private String iliskiliTabloKolonAdi;

    private String viewKolonAdi;

    @ManyToOne
    private TabloBilgisi tabloBilgisi;
}
