package tr.gov.tuik.urunenvanteri.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Data
@Audited
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Dosya extends AuditableEntity{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String adi;
    private String uri;
    private String tipi;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    private byte[] size;


}
