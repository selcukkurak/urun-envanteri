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
public class IletisimKisi extends AuditableEntity {

    @Id
    private Long id;
    private Long tcKimlikNo;
    private String adSoyad;
    private String unvan;
    private String birimId;
    private String disBirimId;
    private String disBirimAdi;
    private String telefon;
    private String eposta;
    private boolean kurumDisi;

    @ManyToOne
    private IdariKayit idariKayit;
}
