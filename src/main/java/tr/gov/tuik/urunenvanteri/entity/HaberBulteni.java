package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Audited
public class HaberBulteni extends AuditableEntity {

    @Id
    private String id;

    private String adi;

    private String donemi;

    private Long sonYayinId;

    private Boolean taslak;

    @OneToMany(mappedBy = "bulten")
    public List<HaberBulteniTablo> tablolar = new ArrayList<>();

    @OneToMany(mappedBy = "bulten")
    public List<HaberBulteniIstatikselTablo> istatikselTablolar = new ArrayList<>();



}
