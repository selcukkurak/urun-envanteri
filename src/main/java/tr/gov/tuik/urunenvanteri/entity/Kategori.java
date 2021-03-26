package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Audited
public class Kategori extends  AuditableEntity{
    @Id
    private Long id;

    private String adi;
}
