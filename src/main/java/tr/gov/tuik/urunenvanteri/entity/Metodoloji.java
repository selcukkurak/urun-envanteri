package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@Audited
public class Metodoloji extends AuditableEntity {

    @Id
    private Long id;
    @Column(name = "urun_id", updatable = false, insertable = false)
    private Long urunId;
    private String adi;
    private String standartiBelirleyenKurum;
    private String dokumanAdi;
    private String url;
    private String gecerlilikTarihi;
    @ManyToOne
    private Urun urun;




}
