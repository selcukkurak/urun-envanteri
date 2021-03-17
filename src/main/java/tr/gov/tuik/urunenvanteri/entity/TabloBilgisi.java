package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Audited
@Table(name = "tablo_bilgileri")
public class TabloBilgisi extends AuditableEntity {

    @Id
    private Long id;

    private String adi;

    private String aciklama;


    @Column(name = "view_adi")
    private String viewAdi;

    @OneToMany(mappedBy = "tabloBilgisi")
    private List<KolonBilgisi> kolonBilgileri = new ArrayList<>();

    @ManyToOne
    private IdariKayit idariKayit;


}