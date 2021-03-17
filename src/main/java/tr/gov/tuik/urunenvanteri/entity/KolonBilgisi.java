package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Audited
@Table(name = "kolon_bilgileri")
public class KolonBilgisi extends AuditableEntity{

    @Id
    private Long id;

    private String adi;

    private String aciklama;

    @Column(name = "key_kontrol")
    private Long keyKontrol;

    @Column(name = "iliskili_tablo_kolon_adi")
    private String iliskiliTabloKolonAdi;

    @Column(name = "view_kolon_adi")
    private String viewKolonAdi;

    @ManyToOne
    private TabloBilgisi tabloBilgisi;
}
