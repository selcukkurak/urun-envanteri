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
public class Metaveriler extends AuditableEntity{

    @Id
    private Long id;

    private String adi;

    private String tad;

    @OneToMany(mappedBy = "metaveri")
    private List<MetaveriBaslik> basliklar = new ArrayList<>();
}
