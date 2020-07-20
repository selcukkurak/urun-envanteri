package tr.gov.tuik.urunenvanteri.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "uretim_siklik")
public class UretimSiklik {

    @Id
    private Integer id;
    private String adi;
}
