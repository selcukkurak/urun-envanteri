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
public class Kategori extends  AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String adi;

    @OneToMany(mappedBy = "kategori")
    public List<HaberBulteniIstatikselTablo> istatikselTablolar = new ArrayList<>();

    @ManyToOne
    public HaberBulteni bulten;
}
